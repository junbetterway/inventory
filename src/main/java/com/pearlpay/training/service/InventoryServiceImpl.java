package com.pearlpay.training.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pearlpay.training.dto.InventoryDTO;
import com.pearlpay.training.entity.Inventory;
import com.pearlpay.training.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	private final InventoryRepository inventoryRepository;

	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	public List<InventoryDTO> findAll() {
		return inventoryRepository.findAll().stream().map(inventory -> {
			InventoryDTO dto = InventoryDTO.builder()
										   .name(inventory.getName())
										   .price(inventory.getPrice())
										   .id(inventory.getId())
										   .dateCreated(inventory.getDateCreated())
										   .build();
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<InventoryDTO> findById(Long id) {
		return inventoryRepository.findById(id).map(inventory -> {
			InventoryDTO dto = InventoryDTO.builder()
					   .name(inventory.getName())
					   .price(inventory.getPrice())
					   .id(inventory.getId())
					   .dateCreated(inventory.getDateCreated())
					   .build();
			return dto;	
		});
	}

	@Override
	public Inventory testByJun(Long id, LocalDate date) {
		return inventoryRepository.findTopByPurchaseOrderIdAndDateCreatedGreaterThanEqualOrderByDateCreatedDesc(id, date);
	}

}
