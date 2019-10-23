package com.pearlpay.training.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearlpay.training.dto.PurchaseOrderDTO;
import com.pearlpay.training.entity.PurchaseOrder;
import com.pearlpay.training.service.PurchaseOrderService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseOrderController {

	private final PurchaseOrderService purchaseOrderService;
	
	public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	@PostMapping
	public ResponseEntity<Long> savePurchaseOrder(@RequestBody PurchaseOrderDTO input) {
					
		PurchaseOrder orderInput = purchaseOrderService.constructFromDto(input);
		
		log.debug("Saving Purchase order: ", orderInput);
		
		return new ResponseEntity<>(purchaseOrderService.save(orderInput).getId(), HttpStatus.OK);
	
	}
	
	@GetMapping("{purchaseOrderId}")
	public ResponseEntity<PurchaseOrderDTO> getPurchaseOrder(@PathVariable Long purchaseOrderId) {
		
		log.debug("Retrieving Purchase Order with id: {}", purchaseOrderId);
		
		return purchaseOrderService.findById(purchaseOrderId).map( dto -> {
												return new ResponseEntity<>(dto, HttpStatus.OK);
											}).orElse(ResponseEntity.notFound().build());
	}

}
















