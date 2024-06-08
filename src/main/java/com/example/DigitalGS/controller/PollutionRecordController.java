package com.example.DigitalGS.controller;

import com.example.DigitalGS.dto.PollutionRecordDTO;
import com.example.DigitalGS.service.PollutionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pollution")
public class PollutionRecordController {
    @Autowired
    private PollutionRecordService service;

    @GetMapping
    public String listPollutionRecords(Model model) {
        model.addAttribute("pollutionRecord", new PollutionRecordDTO());
        model.addAttribute("records", service.getAllPollutionRecords());
        return "records";
    }

    @PostMapping
    public String addPollutionRecord(PollutionRecordDTO record, Model model) {
        service.savePollutionRecord(record);
        return "redirect:/pollution";
    }
}
