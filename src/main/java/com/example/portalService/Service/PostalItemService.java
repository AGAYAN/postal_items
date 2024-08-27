package com.example.portalService.Service;

import com.example.portalService.Entity.HistoryEntity;
import com.example.portalService.Entity.PortalItemEntity;
import com.example.portalService.Entity.PortalOfficeEntity;
import com.example.portalService.Entity.PortalStatus;
import com.example.portalService.repository.PortalItemRepository;
import com.example.portalService.repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostalItemService {
    @Autowired
    private PortalItemRepository portalItemRepository;

    @Autowired
    private PostOfficeRepository portalOfficeRepository;

    public PortalItemEntity registerItem(PortalItemEntity item) {
        item.setStatus(PortalStatus.REGISTERED);
        return portalItemRepository.save(item);
    }

    public PortalItemEntity arriveAtOffice(Long itemId, Long officeId) {
        PortalItemEntity item = portalItemRepository.findById(itemId).orElseThrow();
        PortalOfficeEntity office = portalOfficeRepository.findById(officeId).orElseThrow();

        item.setStatus(PortalStatus.IN_TRANSIT);

        HistoryEntity history = new HistoryEntity();
        history.setPortalItem(item);
        history.setPortalOffice(office);
        history.setTimestamp(LocalDateTime.now());
        history.setEvent(PortalStatus.IN_TRANSIT.toString());

        item.getHistory().add(history);

        return portalItemRepository.save(item);
    }

    public PortalItemEntity departOffice(Long itemId, Long officeId) {
        PortalItemEntity item = portalItemRepository.findById(itemId).orElseThrow();
        PortalOfficeEntity office = portalOfficeRepository.findById(officeId).orElseThrow();

        HistoryEntity history = new HistoryEntity();
        history.setPortalItem(item);
        history.setPortalOffice(office);
        history.setTimestamp(LocalDateTime.now());
        history.setEvent("Departed " + office.getName());

        item.getHistory().add(history);

        return portalItemRepository.save(item);
    }

    public PortalItemEntity getItemStatus(Long itemId) {
        return portalItemRepository.findById(itemId).orElseThrow();
    }
}
