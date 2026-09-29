package com.example.springpracticaldemo.service;

import com.example.springpracticaldemo.entity.Role;
import com.example.springpracticaldemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }
}
