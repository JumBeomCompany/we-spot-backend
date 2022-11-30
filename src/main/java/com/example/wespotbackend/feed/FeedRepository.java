package com.example.wespotbackend.feed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    @Override
    @Modifying
    @Query(value = "DELETE FROM Feed WHERE id = :feedId")
    void deleteById(Long feedId);
}