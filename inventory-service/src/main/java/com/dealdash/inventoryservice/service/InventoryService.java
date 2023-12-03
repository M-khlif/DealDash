package com.dealdash.inventoryservice.service;

import com.dealdash.inventoryservice.dto.InventoryResponse;
import com.dealdash.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    // @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> listOfSkuCodes) {
        return inventoryRepository.findBySkuCodeIn(listOfSkuCodes).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skyCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}
