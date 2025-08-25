package com.example.mcp.demo.dto;

import com.example.mcp.demo.entity.AlarmSeverity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AlarmDto(String title,
                       String description,
                       LocalDateTime alarmTime,
                       AlarmSeverity priority,
                       boolean active) {
}
