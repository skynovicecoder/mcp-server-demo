package com.example.mcp.demo.configs;

import com.example.mcp.demo.service.AlarmHistoryService;
import com.example.mcp.demo.service.AlarmService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolsConfig {
    @Bean
    public List<ToolCallback> findTools(AlarmService alarmService, AlarmHistoryService alarmHistoryService) {
        return List.of(ToolCallbacks.from(alarmService, alarmHistoryService));
    }
}