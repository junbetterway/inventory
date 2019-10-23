package com.pearlpay.training.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearlpay.training.dto.InventoryDTO;
import com.pearlpay.training.entity.Inventory;
import com.pearlpay.training.service.InventoryService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "http://127.0.0.1:8887")
@Log4j2
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

	private final InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<InventoryDTO>> getInventories() {
		
		log.debug("Retrieving a list of inventories");
		
		return new ResponseEntity<>(inventoryService.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<InventoryDTO> getInventory(@PathVariable Long id) {
		
		log.debug("Retrieving  inventory by Id: {}", id);
		
		return inventoryService.findById(id)
								.map(inventory -> new ResponseEntity<>(inventory, HttpStatus.OK))
								.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/testing")
	public ResponseEntity<Inventory> getInventoriesTest() {
			
		return new ResponseEntity<>(inventoryService.testByJun(new Long(1), LocalDate.now()), HttpStatus.OK);
		
	}

}
















