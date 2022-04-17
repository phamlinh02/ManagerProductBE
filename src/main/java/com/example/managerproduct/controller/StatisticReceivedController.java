package com.example.managerproduct.controller;


import com.example.managerproduct.dto.DeliveryDTO;
import com.example.managerproduct.dto.ReceivedDTO;
import com.example.managerproduct.service.StatisticDeliveryService;
import com.example.managerproduct.service.StatisticReceivedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statistic/received/")
public class StatisticReceivedController {

    private final StatisticReceivedService statisticService;

    public StatisticReceivedController(StatisticReceivedService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("all")
    public ResponseEntity<List<ReceivedDTO>> getAll(){
        return new ResponseEntity<>(this.statisticService.getAll(), HttpStatus.OK);
    }

    @GetMapping("find-after-date/{date}")
    public ResponseEntity<List<ReceivedDTO>> getAfterDate(
            @PathVariable("date") String date
    ){
        return new ResponseEntity<>(this.statisticService.getAfterDate(date,true), HttpStatus.OK);
    }
    @GetMapping("find-before-date/{date}")
    public ResponseEntity<List<ReceivedDTO>> getBeforeDate(
            @PathVariable("date") String date
    ){
        return new ResponseEntity<>(this.statisticService.getAfterDate(date,false), HttpStatus.OK);
    }
    @GetMapping("find-around-date")
    public ResponseEntity<List<ReceivedDTO>> getAroundDate(
            @RequestParam String startDate,
            @RequestParam String endDate
    ){
        return new ResponseEntity<>(this.statisticService.getAroundDate(startDate,endDate), HttpStatus.OK);
    }

    @GetMapping("find-by-month-year")
    public ResponseEntity<List<ReceivedDTO>> getByMonthYear(
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
