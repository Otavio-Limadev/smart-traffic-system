package com.smarttraffic.backend.repository;

import com.smarttraffic.backend.model.TrafficHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficHistoryRepository extends JpaRepository<TrafficHistory, Long> {
    // busca histórico de cruzamento especifico
    List<TrafficHistory> findByIntersectionIdOrderByTimestampDesc(Long intersectionId);
}