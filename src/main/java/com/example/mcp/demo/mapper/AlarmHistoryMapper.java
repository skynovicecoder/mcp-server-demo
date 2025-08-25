package com.example.mcp.demo.mapper;

import com.example.mcp.demo.dto.AlarmHistoryDto;
import com.example.mcp.demo.entity.AlarmHistory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AlarmHistoryMapper {
    AlarmHistory toAlarmHistory(AlarmHistoryDto alarmHistoryDto);
}