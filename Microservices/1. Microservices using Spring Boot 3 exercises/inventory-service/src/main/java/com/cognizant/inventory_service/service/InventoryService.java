package com.cognizant.inventory_service.service;

import com.cognizant.inventory_service.model.Inventory;
import com.cognizant.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory getInventoryByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
