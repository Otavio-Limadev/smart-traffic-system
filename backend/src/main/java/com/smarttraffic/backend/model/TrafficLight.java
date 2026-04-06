package com.smarttraffic.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TrafficLight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // faz com que o banco salve o nome da cor (RED, GREEN...) e não só o número
    @Enumerated(EnumType.STRING)
    private LightState state = LightState.RED;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "intersection_id")
    private Intersection intersection;

    public TrafficLight() {
    }

    // Define as cores permitidas para o semáforo
    public enum LightState {
        GREEN, YELLOW, RED
    }

    // Getters e Setters, spring converter para JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LightState getState() {
        return state;
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public Intersection getIntersection() {
        return intersection;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
    }
}