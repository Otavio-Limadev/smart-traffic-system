package com.smarttraffic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TrafficHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // vincula log ao cruzamento específico
    @ManyToOne
    @JoinColumn(name = "intersection_id")
    private Intersection intersection;

    private int carCount;
    private String condition;

    // momento exato em que o dado chegou
    private LocalDateTime timestamp;

    public TrafficHistory() {}

    public TrafficHistory(Intersection intersection, int carCount, String condition) {
        this.intersection = intersection;
        this.carCount = carCount;
        this.condition = condition;
        this.timestamp = LocalDateTime.now(); // hora atual do sistema
    }

    // getters
    public Long getId() { return id; }
    public Intersection getIntersection() { return intersection; }
    public int getCarCount() { return carCount; }
    public String getCondition() { return condition; }
    public LocalDateTime getTimestamp() { return timestamp; }
}