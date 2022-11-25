package com.example.wespotbackend.marker;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarkerRepository extends JpaRepository<Marker, Long> {

    Optional<Marker> findByMakerLocation(MarkerLocation markerLocation);

    @EntityGraph(attributePaths = {"feed"})
    List<Marker> findByUserId(Long userId);

    @Override
    @EntityGraph(attributePaths = {"feed"})
    Optional<Marker> findById(Long markerId);
}
