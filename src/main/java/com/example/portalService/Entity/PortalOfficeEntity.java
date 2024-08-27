package com.example.portalService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "portal_office")
public class PortalOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String index;
    private String name;
    private String address;
}