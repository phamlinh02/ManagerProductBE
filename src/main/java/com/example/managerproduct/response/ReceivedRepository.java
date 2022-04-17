package com.example.managerproduct.response;

import com.example.managerproduct.domain.Received;
import com.example.managerproduct.dto.ReceivedDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceivedRepository extends JpaRepository<Received, Integer> {

    @Query(name ="getAllReceived", nativeQuery = true)
    List<ReceivedDTO> getAllReceived();

    @Query(value = "select r.rec_date from received r", nativeQuery = true)
    List<String> getMonth();
}