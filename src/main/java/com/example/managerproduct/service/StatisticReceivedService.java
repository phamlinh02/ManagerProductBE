package com.example.managerproduct.service;

import com.example.managerproduct.dto.DeliveryDTO;
import com.example.managerproduct.dto.ReceivedDTO;
import com.example.managerproduct.response.ReceivedDetailsRepository;
import com.example.managerproduct.response.ReceivedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticReceivedService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private final ModelMapper mapper = new ModelMapper();
    private final ReceivedRepository receivedRepository;
    private final ReceivedDetailsRepository receivedDetailsRepository;

    public StatisticReceivedService(ReceivedRepository receivedRepository, ReceivedDetailsRepository receivedDetailsRepository) {
        this.receivedRepository = receivedRepository;
        this.receivedDetailsRepository = receivedDetailsRepository;
    }


    public List<ReceivedDTO> getAll() {
        return this.receivedRepository.getAllReceived();
    }

    public List<ReceivedDTO> getAfterDate(String date, boolean check) {
        Date dateTime = convertToDate(date);

        if(check)
        {
            return this.getAll().stream()
                    .filter(receivedDTO -> {
                        Date date1 = convertToDate(receivedDTO.getRecDate());
                        return date1.after(dateTime);
                    })
                    .collect(Collectors.toList());
        } else {
            return this.getAll().stream()
                    .filter(receivedDTO -> {
                        Date date1 = convertToDate(receivedDTO.getRecDate());
                        return date1.before(dateTime);
                    })
                    .collect(Collectors.toList());
        }

    }

    public List<ReceivedDTO> getAroundDate(String start, String end) {
        Date startDate = convertToDate(start);
        Date endDate = convertToDate(end);

        return this.getAll().stream()
                .filter(receivedDTO -> {
                    Date date1 = convertToDate(receivedDTO.getRecDate());
                    return date1.after(startDate);
                })
                .filter(receivedDTO -> {
                    Date date1 = convertToDate(receivedDTO.getRecDate());
                    return date1.before(endDate);
                })
                .collect(Collectors.toList());

    }

    public List<ReceivedDTO> getByMonthAndYear(String month, String year) {

        if (!month.equals("")){
            return this.getAll().stream()
                    .filter(receivedDTO -> {
                        String monthDB = receivedDTO.getRecDate().substring(3, 5);
                        return monthDB.equals(month);
                    })
                    .filter(receivedDTO -> {
                        String yearDB = receivedDTO.getRecDate().substring(6, receivedDTO.getRecDate().length());
                        return yearDB.equals(year);
                    })
                    .collect(Collectors.toList());
        } else {
            return this.getAll().stream()
                    .filter(receivedDTO -> {
                        String yearDB = receivedDTO.getRecDate().substring(6, receivedDTO.getRecDate().length());
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
        this.receivedRepository.getMonth().forEach(
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
