package com.example.mcp.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="alarm", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "alarm_time"}))
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    // Optional description of the alarm
    private String description;

    // Time when the alarm should trigger
    @Column(nullable = false)
    private LocalDateTime alarmTime;

    // Whether the alarm is active or not
    @Column(nullable = false)
    private boolean active = true;

    // Priority of the alarm (e.g., LOW, MEDIUM, HIGH)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlarmSeverity priority = AlarmSeverity.MEDIUM;

    private String source;
}
