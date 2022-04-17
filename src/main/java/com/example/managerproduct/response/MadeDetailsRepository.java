package com.example.managerproduct.response;

import com.example.managerproduct.domain.MadeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MadeDetailsRepository extends JpaRepository<MadeDetails, Integer> {
}