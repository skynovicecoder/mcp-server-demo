package com.example.mcp.demo.mapper;

import com.example.mcp.demo.dto.AlarmDto;
import com.example.mcp.demo.entity.Alarm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
@Component
public interface AlarmMapper {
    @Mapping(target = "alarmTime", expression = "java(getCurrentDate())")
    Alarm toAlarm(AlarmDto alarmDto);

    @Named("getCurrentDate")
    default LocalDateTime getCurrentDate() {
        return LocalDateTime.now();
    }
}