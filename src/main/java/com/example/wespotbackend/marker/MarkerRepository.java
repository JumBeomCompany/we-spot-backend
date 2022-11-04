package com.example.wespotbackend.marker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarkerRepository extends JpaRepository<Marker, Long> {

    Optional<Marker> findByMakerLocation(MarkerLocation markerLocation);

    List<Marker> findByUserId(Long userId);
}
