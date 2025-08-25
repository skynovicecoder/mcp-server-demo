package com.example.mcp.demo.service;

import com.example.mcp.demo.dto.AlarmHistoryDto;
import com.example.mcp.demo.entity.AlarmHistory;
import com.example.mcp.demo.mapper.AlarmHistoryMapper;
import com.example.mcp.demo.repository.AlarmHistoryRepository;
import com.example.mcp.demo.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlarmHistoryService {
    private final AlarmHistoryRepository alarmHistoryRepository;
    private final AlarmRepository alarmRepository;
    private final AlarmHistoryMapper alarmHistoryMapper;

    @Tool(name = "Get_Alarms_full_Alarm_History_by_Alarm_ID",
            description = "Get Alarms full Alarm History by real Alarm ID")
    public List<AlarmHistory> findByAlarmId(Long alarmId) {
        log.info("Getting Alarm History by Alarm Id: {}", alarmId);
        return alarmHistoryRepository.findByAlarmId(alarmId);
    }

    @Tool(name = "Get_Alarms_Alarm_History_by_Alarm_ID_and_Date_Range",
            description = "Get Alarms Alarm History Alarm ID and Date Range")
    public List<AlarmHistory> findByAlarmIdAndUpdatedTimeBetween(Long alarmId,
                                                                 LocalDateTime startDate,
                                                                 LocalDateTime endDate) {
        log.info("Getting Alarm History by Alarm ID: {} between {} and {}", alarmId, startDate, endDate);
        return alarmHistoryRepository.findByAlarmIdAndUpdatedTimeBetween(alarmId, startDate, endDate);
    }

    @Tool(name = "Adding_Alarm_new_Alarm_History_by_Alarm_ID",
            description = "Adding Alarms new Alarm History record by real Alarm ID")
    public AlarmHistory add(AlarmHistoryDto alarmHistoryDto) {
        // Check if the alarm history already exists for the same alarm and date
        var alarmHistoryExistingOptional =
                alarmHistoryRepository.findByAlarmIdAndUpdatedTime(alarmHistoryDto.alarmId(),
                        alarmHistoryDto.updatedTime());

        if (alarmHistoryExistingOptional.isPresent()) {
            throw new IllegalStateException("Alarm History already exists for the same Alarm and Date");
        }

        var alarm = alarmRepository.findById(alarmHistoryDto.alarmId())
                .orElseThrow(() -> new IllegalStateException("Alarm not found"));

        var alarmHistory = alarmHistoryMapper.toAlarmHistory(alarmHistoryDto);
        alarmHistory.setAlarm(alarm);

        log.info("Adding new Alarm History {}", alarmHistoryDto);
        return alarmHistoryRepository.save(alarmHistory);
    }

    @Tool(name = "Changing_existing_Alarms_Alarm_History",
            description = "Changing existing Alarms Alarm History record by real Alarm ID and UpdateTime")
    public AlarmHistory update(AlarmHistoryDto alarmHistoryDto) {
        log.info("Updating Alarm History {}", alarmHistoryDto);

        // Retrieve the existing alarm history for the specified alarm and updateTime
        return alarmHistoryRepository.findByAlarmIdAndUpdatedTime(alarmHistoryDto.alarmId(),
                        alarmHistoryDto.updatedTime())
                .map(existingHistory -> {
                    mergeAlarmHistory(alarmHistoryDto, existingHistory);
                    return alarmHistoryRepository.save(existingHistory);
                })
                .orElseThrow(() ->
                        new IllegalStateException("Alarm History not found for the given Alarm and UpdateTime "));
    }

    private void mergeAlarmHistory(AlarmHistoryDto alarmHistoryDto, AlarmHistory existingHistory) {
        existingHistory.setNotes(alarmHistoryDto.notes());
        existingHistory.setStatus(alarmHistoryDto.status());
    }
}