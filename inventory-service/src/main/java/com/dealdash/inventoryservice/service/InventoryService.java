package com.dealdash.inventoryservice.service;

import com.dealdash.inventoryservice.dto.InventoryResponse;
import com.dealdash.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<InventoryResponse> isInStock(List<String> listOfSkuCodes) throws InterruptedException {
        log.info("Wait Started");
        Thread.sleep(10000);
        log.info("Wait Started");
        return inventoryRepository.findBySkuCodeIn(listOfSkuCodes).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skyCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}
