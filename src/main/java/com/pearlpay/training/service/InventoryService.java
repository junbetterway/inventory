package com.pearlpay.training.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pearlpay.training.dto.InventoryDTO;
import com.pearlpay.training.entity.Inventory;

public interface InventoryService {
	
	List<InventoryDTO> findAll();
	
	Optional<InventoryDTO> findById(Long id);
	
	Inventory testByJun(Long id, LocalDate date);

}
