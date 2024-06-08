package com.example.DigitalGS.service;

import com.example.DigitalGS.dto.PollutionRecordDTO;
import com.example.DigitalGS.exception.PollutionRecordNotFoundException;
import com.example.DigitalGS.model.PollutionRecord;
import com.example.DigitalGS.repository.PollutionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollutionRecordService {
    @Autowired
    private PollutionRecordRepository repository;

    public List<PollutionRecordDTO> getAllPollutionRecords() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PollutionRecordDTO savePollutionRecord(PollutionRecordDTO recordDTO) {
        PollutionRecord record = convertToEntity(recordDTO);
        return convertToDTO(repository.save(record));
    }

    public PollutionRecordDTO getPollutionRecordById(Long id) {
        PollutionRecord record = repository.findById(id)
                .orElseThrow(() -> new PollutionRecordNotFoundException("Pollution record not found with id " + id));
        return convertToDTO(record);
    }

    private PollutionRecordDTO convertToDTO(PollutionRecord record) {
        PollutionRecordDTO dto = new PollutionRecordDTO();
        dto.setLocation(record.getLocation());
        dto.setPollutionLevel(record.getPollutionLevel());
        dto.setDateRecorded(record.getDateRecorded());
        return dto;
    }

    private PollutionRecord convertToEntity(PollutionRecordDTO dto) {
        PollutionRecord record = new PollutionRecord();
        record.setLocation(dto.getLocation());
        record.setPollutionLevel(dto.getPollutionLevel());
        record.setDateRecorded(dto.getDateRecorded());
        return record;
    }
}
