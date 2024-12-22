package org.example.controller;

import org.example.dto.Report;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ReportController {

    @RequestMapping(method = {RequestMethod.GET}, value = {"/reports"}, produces = {"application/json"})
    ResponseEntity<Report> getReport();

}
