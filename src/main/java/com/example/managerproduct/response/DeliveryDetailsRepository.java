package com.example.managerproduct.response;

import com.example.managerproduct.domain.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, Integer> {
}