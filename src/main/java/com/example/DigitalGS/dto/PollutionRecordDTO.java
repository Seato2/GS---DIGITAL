package com.example.DigitalGS.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PollutionRecordDTO {

    private String location;
    private Double pollutionLevel;
    private LocalDate dateRecorded;

}
