package com.example.portalService.repository;

import com.example.portalService.Entity.PortalItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortalItemRepository extends JpaRepository<PortalItemEntity, Long> {
    Optional<PortalItemEntity> findById(Long id);
}
