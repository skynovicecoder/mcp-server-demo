package com.example.mcp.demo.components;

import com.example.mcp.demo.entity.Alarm;
import com.example.mcp.demo.entity.AlarmHistory;
import com.example.mcp.demo.entity.AlarmSeverity;
import com.example.mcp.demo.entity.AlarmStatus;
import com.example.mcp.demo.repository.AlarmHistoryRepository;
import com.example.mcp.demo.repository.AlarmRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Initialization {
    private final AlarmRepository alarmRepository;
    private final AlarmHistoryRepository alarmHistoryRepository;

    @PostConstruct
    public void init() {
        // Create and save patients
        Alarm switchAlarm = alarmRepository.save(Alarm.builder()
                .title("Switch")
                .description("Switch Alarm")
                .active(true)
                .source("GER")
                .priority(AlarmSeverity.LOW)
                .alarmTime(LocalDateTime.now().minusDays(7))
                .build());

        Alarm accessPointAlarm = alarmRepository.save(Alarm.builder()
                .title("AccessPoint")
                .description("Access Point Alarm")
                .active(true)
                .source("UK")
                .priority(AlarmSeverity.LOW)
                .alarmTime(LocalDateTime.now().minusDays(7))
                .build());

        Alarm gatewayAlarm = alarmRepository.save(Alarm.builder()
                .title("Gateway")
                .description("Gateway Access")
                .active(true)
                .source("IND")
                .priority(AlarmSeverity.MEDIUM)
                .alarmTime(LocalDateTime.now().minusDays(6))
                .build());

        Alarm firewallAlarm = alarmRepository.save(Alarm.builder()
                .title("Firewall")
                .description("Firewall Access")
                .active(true)
                .source("JP")
                .priority(AlarmSeverity.LOW)
                .alarmTime(LocalDateTime.now().minusDays(5))
                .build());

        Alarm routerAlarm = alarmRepository.save(Alarm.builder()
                .title("Router")
                .description("Router Access")
                .active(true)
                .source("USA")
                .priority(AlarmSeverity.HIGH)
                .alarmTime(LocalDateTime.now().minusDays(4))
                .build());

        // Create and save example medical histories
        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(switchAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs Care for Switch")
                .updatedTime(LocalDateTime.now())
                .updatedBy("Sakura")
                .status(AlarmStatus.RAISED)
                .build());

        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(accessPointAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs Care Access Point")
                .updatedTime(LocalDateTime.now().minusDays(2))
                .updatedBy("Gokhu")
                .status(AlarmStatus.RESOLVED)
                .build());
        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(accessPointAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs Care Access Point")
                .updatedTime(LocalDateTime.now().minusDays(1))
                .updatedBy("Vegeta")
                .status(AlarmStatus.CLEARED)
                .build());

        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(gatewayAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs to check gateway")
                .updatedTime(LocalDateTime.now().minusDays(2))
                .updatedBy("Luffy")
                .status(AlarmStatus.RESOLVED)
                .build());
        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(gatewayAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs to check gateway")
                .updatedTime(LocalDateTime.now().minusDays(2))
                .updatedBy("Zoro")
                .status(AlarmStatus.CLEARED)
                .build());

        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(firewallAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs to check firewall")
                .updatedTime(LocalDateTime.now().minusDays(2))
                .updatedBy("Naruto")
                .status(AlarmStatus.RESOLVED)
                .build());
        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(firewallAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs to check firewall")
                .updatedTime(LocalDateTime.now().minusDays(2))
                .updatedBy("Sasuke")
                .status(AlarmStatus.CLEARED)
                .build());

        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(routerAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs to check router")
                .updatedTime(LocalDateTime.now().minusDays(2))
                .updatedBy("Ash")
                .status(AlarmStatus.RESOLVED)
                .build());
        alarmHistoryRepository.save(AlarmHistory.builder()
                .alarm(routerAlarm)
                .createdTime(accessPointAlarm.getAlarmTime())
                .notes("Needs to check router")
                .updatedTime(LocalDateTime.now().minusDays(1))
                .updatedBy("Pikachu")
                .status(AlarmStatus.CLEARED)
                .build());

    }
}