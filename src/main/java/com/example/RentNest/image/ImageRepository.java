package com.example.RentNest.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
    void deleteByName(String housesName);
    Optional<List<Image>> findByEntityIdAndEntityType(Long entityId, ImageEntityType entityType);
    Optional<List<Image>> findByEntityIdAndEntityTypeAndUserId(Long entityId, ImageEntityType entityType ,Long userId);
}
