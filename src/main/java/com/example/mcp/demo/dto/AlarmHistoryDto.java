package com.example.mcp.demo.dto;

import com.example.mcp.demo.entity.AlarmStatus;

import java.time.LocalDateTime;

public record AlarmHistoryDto(Long alarmId,
                              AlarmStatus status,
                              LocalDateTime updatedTime,
                              String updatedBy,
                              LocalDateTime createdTime,
                              String notes) {
}