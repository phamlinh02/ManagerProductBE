package com.example.managerproduct.service;

import com.example.managerproduct.dto.DeliveryDTO;
import com.example.managerproduct.response.DeliveryDetailsRepository;
import com.example.managerproduct.response.DeliveryRepository;
import com.example.managerproduct.response.ReceivedDetailsRepository;
import com.example.managerproduct.response.ReceivedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticDeliveryService {


  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
  private final ModelMapper mapper = new ModelMapper();
  private final DeliveryRepository deliveryRepository;
  private final DeliveryDetailsRepository deliveryDetailsRepository;

  public StatisticDeliveryService( DeliveryRepository deliveryRepository, DeliveryDetailsRepository deliveryDetailsRepository) {
    this.deliveryRepository = deliveryRepository;
    this.deliveryDetailsRepository = deliveryDetailsRepository;
  }


  public List<DeliveryDTO> getAll() {
    return this.deliveryRepository.getListAll();
  }

  public List<DeliveryDTO> getAfterDate(String date, boolean check) {
    Date dateTime = convertToDate(date);

    if(check)
    {
      return this.getAll().stream()
        .filter(deliveryDTO -> {
          Date date1 = convertToDate(deliveryDTO.getDelivDate());
          return date1.after(dateTime);
        })
        .collect(Collectors.toList());
    } else {
      return this.getAll().stream()
        .filter(deliveryDTO -> {
          Date date1 = convertToDate(deliveryDTO.getDelivDate());
          return date1.before(dateTime);
        })
        .collect(Collectors.toList());
    }

  }

  public List<DeliveryDTO> getAroundDate(String start, String end) {
    Date startDate = convertToDate(start);
    Date endDate = convertToDate(end);

    return this.getAll().stream()
      .filter(deliveryDTO -> {
        Date date1 = convertToDate(deliveryDTO.getDelivDate());
        return date1.after(startDate);
      })
      .filter(deliveryDTO -> {
        Date date1 = convertToDate(deliveryDTO.getDelivDate());
        return date1.before(endDate);
      })
      .collect(Collectors.toList());

  }

  public List<DeliveryDTO> getByMonthAndYear(String month, String year) {

    if (!month.equals("")){
      return this.getAll().stream()
        .filter(deliveryDTO -> {
          String monthDB = deliveryDTO.getDelivDate().substring(3, 5);
          return monthDB.equals(month);
        })
        .filter(deliveryDTO -> {
          String yearDB = deliveryDTO.getDelivDate().substring(6, deliveryDTO.getDelivDate().length());
          return yearDB.equals(year);
        })
        .collect(Collectors.toList());
    } else {
      return this.getAll().stream()
        .filter(deliveryDTO -> {
          String yearDB = deliveryDTO.getDelivDate().substring(6, deliveryDTO.getDelivDate().length());
          return yearDB.equals(year);
        })
        .collect(Collectors.toList());
    }

  }


  private Date convertToDate(String date) {
    Date dateTime = null;
    try {
      dateTime = sdf.parse(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dateTime;
  }

  public List<String> getMonth(){
    List<String> lst = new ArrayList<>();
    this.deliveryRepository.getMonth().forEach(
            s -> {
              String month = s.substring(3,5);
              lst.add(month);
            }
    );
    lst.stream()
            .distinct()
            .collect(Collectors.toList());
    return lst;
  }

}
