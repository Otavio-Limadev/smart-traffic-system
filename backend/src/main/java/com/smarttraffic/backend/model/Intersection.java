package com.smarttraffic.backend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Intersection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int currentCarCount;

    // Enum para as condições da via
    public enum RoadCondition {
        NORMAL, ACCIDENT, HEAVY_RAIN
    }

    @Enumerated(EnumType.STRING)
    private RoadCondition condition = RoadCondition.NORMAL;

    // Semáforos
    @OneToMany(mappedBy = "intersection", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TrafficLight> trafficLights = new ArrayList<>();

    // JPA
    public Intersection() {
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentCarCount() {
        return currentCarCount;
    }

    public void setCurrentCarCount(int currentCarCount) {
        this.currentCarCount = currentCarCount;
    }

    public RoadCondition getCondition() {
        return condition;
    }

    public void setCondition(RoadCondition condition) {
        this.condition = condition;
    }

    public List<TrafficLight> getTrafficLights() {
        return trafficLights;
    }

    public void setTrafficLights(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
    }
}