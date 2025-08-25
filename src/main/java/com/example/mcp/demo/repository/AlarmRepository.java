package com.example.mcp.demo.repository;

import com.example.mcp.demo.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    List<Alarm> findByTitle(String title);

    List<Alarm> findByTitleAndPriority(String title, String priority);

    Optional<Alarm> findByTitleAndPriorityAndAlarmTime(String title, String priority, LocalDateTime alarmTime);
}
