package com.example.portalService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "portal_item")
public class PortalItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipientName;
    private String type;
    private String recipientIndex;
    private String recipientAddress;

    @Enumerated(EnumType.STRING)
    private PortalStatus status;

    @OneToMany(mappedBy = "portalItem", cascade = CascadeType.ALL)
    private List<HistoryEntity> history;
}