package com.example.mcp.demo.service;

import com.example.mcp.demo.dto.AlarmDto;
import com.example.mcp.demo.entity.Alarm;
import com.example.mcp.demo.mapper.AlarmMapper;
import com.example.mcp.demo.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlarmService {

    private final AlarmRepository alarmRepository;
    private final AlarmMapper alarmMapper;

    @Tool(name = "Find_All_Alarms", description = "Find a complete list of Alarms")
    public List<Alarm> findAll() {
        log.info("Finding all Alarms");
        return alarmRepository.findAll();
    }

    @Tool(name = "Find_Alarm_by_Title", description = "Find Alarm by given Title")
    public List<Alarm> findByLastName(String title) {
        log.info("Finding Alarm by Title {}", title);
        return alarmRepository.findByTitle(title);
    }

    @Tool(name = "Find_Alarm_by_Fist_And_Last_Name", description = "Find Alarm by given Title And Priority")
    public List<Alarm> findByTitleAndPriority(String title, String priority) {
        log.info("Finding Alarm by Title {} and Priority {}", title, priority);
        return alarmRepository.findByTitleAndPriority(title, priority);
    }

    @Tool(name = "Find_Alarm_by_Title_And_Priority_and_Alarm_Time",
            description = "Find Alarm by given Title And Priority and Date of AlarmTime")
    public Optional<Alarm> findByTitleAndPriorityAndAlarmTime(String title,
                                                              String priority,
                                                              LocalDateTime alarmTime) {
        log.info("Finding Patient by Title {} and Priority {} and Date of AlarmTime {}",
                title, priority, alarmTime);
        return alarmRepository.findByTitleAndPriorityAndAlarmTime(title, priority, alarmTime);
    }

    @Tool(name = "Adding_new_Alarm",
            description = "Adding new Alarm information")
    public Alarm add(AlarmDto alarmDto) {
        Optional<Alarm> alarmExistingOptional
                = alarmRepository.findByTitleAndPriorityAndAlarmTime(alarmDto.title(),
                String.valueOf(alarmDto.priority()),
                alarmDto.alarmTime());

        if (alarmExistingOptional.isPresent()) {
            throw new IllegalArgumentException("Alarm already exists");
        }

        log.info("Adding new Alarm {}", alarmDto);
        return alarmRepository.save(alarmMapper.toAlarm(alarmDto));
    }
}