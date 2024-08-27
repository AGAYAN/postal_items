package com.example.portalService.controller;

import com.example.portalService.Entity.PortalItemEntity;
import com.example.portalService.Service.PostalItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/items")
public class PostalItemController {
    @Autowired
    private PostalItemService service;

    @PostMapping
    public ResponseEntity<PortalItemEntity> registerItem(@RequestBody PortalItemEntity item) {
        PortalItemEntity registered = service.registerItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(registered);
    }

    @PostMapping("/{id}/arrive")
    public ResponseEntity<PortalItemEntity> arriveAtOffice(@PathVariable Long id, @RequestParam Long officeId) {
        PortalItemEntity arrived = service.arriveAtOffice(id, officeId);
        return ResponseEntity.ok(arrived);
    }

    @PostMapping("/{id}/depart")
    public ResponseEntity<PortalItemEntity> departOffice(@PathVariable Long id, @RequestParam Long officeId) {
        PortalItemEntity departed = service.departOffice(id, officeId);
        return ResponseEntity.ok(departed);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortalItemEntity> getItemStatus(@PathVariable Long id) {
        PortalItemEntity item = service.getItemStatus(id);
        return ResponseEntity.ok(item);
    }
}
