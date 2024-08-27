package com.example.portalService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portal_item_id")
    private PortalItemEntity portalItem;

    @ManyToOne
    @JoinColumn(name = "portal_office_id")
    private PortalOfficeEntity portalOffice;

    private LocalDateTime timestamp;
    private String event;
}