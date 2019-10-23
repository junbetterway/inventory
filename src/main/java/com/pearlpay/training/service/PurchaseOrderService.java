package com.pearlpay.training.service;

import java.util.Optional;

import com.pearlpay.training.dto.PurchaseOrderDTO;
import com.pearlpay.training.entity.PurchaseOrder;

public interface PurchaseOrderService {

	PurchaseOrder constructFromDto(PurchaseOrderDTO input);
	PurchaseOrderDTO save(PurchaseOrder purchaseOrder);
	Optional<PurchaseOrderDTO> findById(Long id);
	
}
