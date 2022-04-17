package com.example.managerproduct.response;

import com.example.managerproduct.domain.Delivery;
import com.example.managerproduct.dto.DeliveryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

  @Query(name = "getDelivery", nativeQuery = true)
  List<DeliveryDTO> getListAll();

  @Query(value = "select d.deliv_date from delivery d", nativeQuery = true)
  List<String> getMonth();
}
