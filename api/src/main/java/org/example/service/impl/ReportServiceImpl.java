package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Report;
import org.example.service.ReportService;
import org.example.util.GenerateRandom;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    @Override
    public Report getReport() {
        return Report.builder()
                .number(GenerateRandom.generateRandomInt(55))
                .code(GenerateRandom.generateRandomString(3))
                .name(GenerateRandom.generateRandomString(5))
                .build();
    }

}
