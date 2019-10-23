package com.pearlpay.training.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearlpay.training.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	Inventory findTopByPurchaseOrderIdAndDateCreatedGreaterThanEqualOrderByDateCreatedDesc(Long id, LocalDate date);

}
