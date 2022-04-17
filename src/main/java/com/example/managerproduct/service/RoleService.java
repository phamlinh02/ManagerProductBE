package com.example.managerproduct.service;

import com.example.managerproduct.dto.RoleDTO;
import com.example.managerproduct.response.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;


    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> getAll(){
        return this.roleRepository.getAll();
    }
}
