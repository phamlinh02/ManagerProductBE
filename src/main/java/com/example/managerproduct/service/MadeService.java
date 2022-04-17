package com.example.managerproduct.service;

import com.example.managerproduct.dto.MadeByDTO;
import com.example.managerproduct.response.MadeByRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MadeService {

    private MadeByRepository madeByRepository;

    public MadeService(MadeByRepository madeByRepository) {
        this.madeByRepository = madeByRepository;
    }

    public List<MadeByDTO> getAll(){
        return this.madeByRepository.getAll();
    }
}
