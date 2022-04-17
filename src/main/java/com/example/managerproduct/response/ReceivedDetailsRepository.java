package com.example.managerproduct.response;

import com.example.managerproduct.domain.ReceivedDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivedDetailsRepository extends JpaRepository<ReceivedDetails, Integer> {
}