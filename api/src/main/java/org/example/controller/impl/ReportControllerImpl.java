package org.example.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.ReportController;
import org.example.dto.Report;
import org.example.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ReportControllerImpl implements ReportController {

    private final ReportService reportService;

    @Override
    public ResponseEntity<Report> getReport() {
        return ResponseEntity.ok(reportService.getReport());
    }
}
