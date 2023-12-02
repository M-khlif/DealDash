package com.dealdash.inventoryservice.service;

import com.dealdash.inventoryservice.model.Inventory;
import com.dealdash.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    // @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Optional<Inventory> inventoryObject = inventoryRepository.findBySkuCode(skuCode);
        return inventoryObject.isPresent();
    }
}
