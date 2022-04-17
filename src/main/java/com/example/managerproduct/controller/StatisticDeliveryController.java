package com.example.managerproduct.controller;

import com.example.managerproduct.dto.DeliveryDTO;
import com.example.managerproduct.service.StatisticDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statistic/delivery/")
public class StatisticDeliveryController {

  private final StatisticDeliveryService statisticService;

  public StatisticDeliveryController(StatisticDeliveryService statisticService) {
    this.statisticService = statisticService;
  }

  @GetMapping("all")
  public ResponseEntity<List<DeliveryDTO>> getAll(){
    return new ResponseEntity<>(this.statisticService.getAll(), HttpStatus.OK);
  }

  @GetMapping("find-after-date/{date}")
  public ResponseEntity<List<DeliveryDTO>> getAfterDate(
    @PathVariable("date") String date
  ){
    return new ResponseEntity<>(this.statisticService.getAfterDate(date,true), HttpStatus.OK);
  }
  @GetMapping("find-before-date/{date}")
  public ResponseEntity<List<DeliveryDTO>> getBeforeDate(
    @PathVariable("date") String date
  ){
    return new ResponseEntity<>(this.statisticService.getAfterDate(date,false), HttpStatus.OK);
  }
  @GetMapping("find-around-date")
  public ResponseEntity<List<DeliveryDTO>> getAroundDate(
    @RequestParam String startDate,
    @RequestParam String endDate
  ){
    return new ResponseEntity<>(this.statisticService.getAroundDate(startDate,endDate), HttpStatus.OK);
  }

  @GetMapping("find-by-month-year")
  public ResponseEntity<List<DeliveryDTO>> getByMonthYear(
    @RequestParam String month,
    @RequestParam String year
  ){
    return new ResponseEntity<>(this.statisticService.getByMonthAndYear(month, year), HttpStatus.OK);
  }

  @GetMapping("get-month")
  public ResponseEntity<List<String>> getMonth(
  ){
    return new ResponseEntity<>(this.statisticService.getMonth(), HttpStatus.OK);
  }


}
