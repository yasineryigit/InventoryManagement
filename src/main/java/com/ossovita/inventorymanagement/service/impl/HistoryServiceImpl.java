package com.ossovita.inventorymanagement.service.impl;

import com.ossovita.inventorymanagement.entity.History;
import com.ossovita.inventorymanagement.repository.HistoryRepository;
import com.ossovita.inventorymanagement.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }
}
