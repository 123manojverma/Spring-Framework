package com.example.cruddtodemo.service;

import com.example.cruddtodemo.dto.CreateStudentRequestDto;
import com.example.cruddtodemo.dto.CreateStudentResponseDto;
import com.example.cruddtodemo.dto.UpdateStudentRequestDto;
import com.example.cruddtodemo.dto.UpdateStudentResponseDto;
import com.example.cruddtodemo.entity.Student;
import com.example.cruddtodemo.exception.DuplicateResourceException;
import com.example.cruddtodemo.exception.ResourceNotFoundException;
import com.example.cruddtodemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReqDto){
        Student student=mapToEntity(studentReqDto);

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email "+student.getEmail()+" already exists");
        }

        Student studentRes=studentRepository.save(student);

        return mapToDto(studentRes);
    }

    public CreateStudentResponseDto getStudent(Long id){
        Student studentRes=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));
        return mapToDto(studentRes);
    }

    public List<CreateStudentResponseDto> getAllStudents(){
        List<Student>students=studentRepository.findByDeletedIsFalse();

        return students.stream().map(this::mapToDto).toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Student existingStudent= studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found"));

        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        Student savedStudent= studentRepository.save(existingStudent);

        return mapToUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id){
        Student studentToBeDeleted= studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));

        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id){
        Student studentToBeDeleted= studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }


    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto){
        Student student=new Student();

        student.setName(createStudentRequestDto.getName());
        student.setAge(createStudentRequestDto.getAge());
        student.setEmail(createStudentRequestDto.getEmail());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setSubject(createStudentRequestDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student){
        CreateStudentResponseDto responseDto=new CreateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student saved successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student){
        UpdateStudentResponseDto responseDto=new UpdateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student updated successfully");
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

    public boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}
