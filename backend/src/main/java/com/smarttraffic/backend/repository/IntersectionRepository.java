package com.smarttraffic.backend.repository;

import com.smarttraffic.backend.model.Intersection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntersectionRepository extends JpaRepository<Intersection, Long> {
    // métodos  save(), findAll() e deleteById()
}