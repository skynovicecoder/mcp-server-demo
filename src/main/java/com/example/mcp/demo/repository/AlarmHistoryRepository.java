package com.example.mcp.demo.repository;

import com.example.mcp.demo.entity.AlarmHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AlarmHistoryRepository extends JpaRepository<AlarmHistory, Long> {
    List<AlarmHistory> findByAlarmId(Long alarmId);

    List<AlarmHistory> findByAlarmIdAndUpdatedTimeBetween(Long alarmId, LocalDateTime startDate, LocalDateTime endDate);

    Optional<AlarmHistory> findByAlarmIdAndUpdatedTime(Long alarmId, LocalDateTime updatedTime);
}
