package com.ossovita.inventorymanagement.controller;

import com.ossovita.inventorymanagement.entity.History;
import com.ossovita.inventorymanagement.service.HistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<History> getAllHistory(){
        return historyService.getAllHistory();
    }
}
