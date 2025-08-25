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
@Table(name = "alarm_history", uniqueConstraints = @UniqueConstraint(columnNames = {"alarm_id", "updated_time"}))
public class AlarmHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to the Alarm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_id", nullable = false)
    private Alarm alarm;

    // Status of alarm at this point in history
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlarmStatus status;

    // Time of this status update
    @Column(nullable = false)
    private LocalDateTime updatedTime;

    // Who/what updated the alarm (system/user/device)
    private String updatedBy;

    @Column(nullable = false)
    private LocalDateTime createdTime;

    // Optional note (e.g., resolution reason, acknowledgement details)
    private String notes;
}