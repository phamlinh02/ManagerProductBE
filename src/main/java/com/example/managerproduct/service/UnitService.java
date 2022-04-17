package com.example.managerproduct.service;

import com.example.managerproduct.domain.MadeBy;
import com.example.managerproduct.dto.UnitDTO;
import com.example.managerproduct.response.MadeByRepository;
import com.example.managerproduct.response.UnitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<UnitDTO> getAll(){
        return this.unitRepository.getAll();
    }
}
