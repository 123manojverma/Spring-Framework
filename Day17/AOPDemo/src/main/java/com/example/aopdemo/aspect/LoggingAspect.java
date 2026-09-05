package com.example.aopdemo.aspect;

import com.example.aopdemo.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String com.example.aopdemo.service.StudentService.createStudent())") // pointcut expression
//    public void logBeforeMethod(JoinPoint joinPoint){
//
//        Object[] arr=joinPoint.getArgs();
//
//        System.out.println("Student is going to be saved");
//
//        throw new RuntimeException("Method Execution not allowed");
//    }

    /*
    @AfterReturning(value = "execution(" +
            "com.example.aopdemo.dto.Student"+
            " com.example.aopdemo.service.StudentService" +
            ".createStudent(com.example.aopdemo.dto.Student))",
    returning = "result")
    public void logAfterReturningMethod(Student result){
//        System.out.println("logAfterReturningMethod called");

//        System.out.println("Target method returned: "+result);

        result.setName("Rohit");
        result.setAge(22);

        System.out.println("Intercepted createStudent()");
    }
     */

    /*

    @AfterThrowing(value = "execution(* com.example.aopdemo.service.StudentService.createStudent(..))",
    throwing = "exception")
    public void logAfterThrowingMethod(Throwable exception){
        System.out.println("Exception type: "+ exception.getClass().getName());
        System.out.println("Exception Message: "+ exception.getMessage());
    }

//    For a particular type exception
    @AfterThrowing(value = "execution(* com.example.aopdemo.service.StudentService.createStudent(..))",
    throwing = "exception")
    public void logAfterThrowingMethod(NullPointerException exception){
        System.out.println("Exception type: "+ exception.getClass().getName());
        System.out.println("Exception Message: "+ exception.getMessage());
    }

     */

//    @After(value="execution(* com.example.aopdemo.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//        System.out.println("logAfterMethod executed");
//    }

    /*
    @Around(value="execution(* com.example.aopdemo.service.StudentService.createStudent(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Starting : "+joinPoint.getSignature().getName());

        try {
            Object result= joinPoint.proceed();
            System.out.println("Execution Successful");
            return result;
        }catch (Exception e){
            System.out.println("Execution Failed : "+e.getMessage());
            throw e;
        }finally {
            System.out.println("Execution Completed");
        }

//        System.out.println("After target method");
//
//        result.setAge(31);
//        result.setName("Aman");
//
//        return result;
    }

     */

    @Around(value = "execution(* com.example.aopdemo.service.StudentService.dummyMethod(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint)throws Throwable{
//        Object[] arr=joinPoint.getArgs();
//        String originalString=(String) arr[0];
//
//        String modifiedString = originalString.toUpperCase();
//
//        Object[] modifiedArr={
//                modifiedString
//        };
//
//        String returnType= (String) joinPoint.proceed(modifiedArr);
//
//        returnType=returnType+": String Intercepted";
//        return returnType;

        Object return1=joinPoint.proceed();

        System.out.println("Intercepted request calling again");

        Object return2=joinPoint.proceed();

        return return2;
    }
}
