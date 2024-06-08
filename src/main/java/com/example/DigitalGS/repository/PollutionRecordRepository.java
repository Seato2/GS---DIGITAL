package com.example.DigitalGS.repository;

import com.example.DigitalGS.model.PollutionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollutionRecordRepository extends JpaRepository<PollutionRecord, Long> {
}
