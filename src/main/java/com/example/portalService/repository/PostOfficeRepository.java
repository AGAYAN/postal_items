package com.example.portalService.repository;

import com.example.portalService.Entity.PortalOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeRepository extends JpaRepository<PortalOfficeEntity, Long> {

}
