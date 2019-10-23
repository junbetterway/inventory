package com.pearlpay.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.pearlpay.training.dto.InventoryDTO;
import com.pearlpay.training.dto.PurchaseOrderDTO;
import com.pearlpay.training.entity.Inventory;
import com.pearlpay.training.entity.PurchaseOrder;
import com.pearlpay.training.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private final PurchaseOrderRepository purchaseOrderRepository;	

	public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
	}

	@Override
	public PurchaseOrderDTO save(PurchaseOrder purchaseOrder) {
	
		PurchaseOrder order = purchaseOrderRepository.save(purchaseOrder);
		PurchaseOrderDTO dto = PurchaseOrderDTO.builder().build();
		BeanUtils.copyProperties(order, dto);
		
		return dto;
	}

	@Override
	public Optional<PurchaseOrderDTO> findById(Long id) {
		
		return purchaseOrderRepository.findById(id).map(purchase -> {
			
			List<InventoryDTO> inventories = purchase.getInventories().stream().map( inventory -> {
				InventoryDTO dto = InventoryDTO.builder().build();
				BeanUtils.copyProperties(inventory, dto);
				return dto;
			}).collect(Collectors.toList());
			
			PurchaseOrderDTO po = PurchaseOrderDTO.builder()
													.id(purchase.getId())
													.dateCreated(purchase.getDateCreated())
													.receiptNumber(purchase.getReceiptNumber())
													.inventories(inventories)
													.build();
			return po;
		});
	}

	@Override
	public PurchaseOrder constructFromDto(PurchaseOrderDTO input) {
		
		List<Inventory> inventories = input.getInventories().stream().map( inventoryDTO -> {
			Inventory newInventory = Inventory.builder().build();
			BeanUtils.copyProperties(inventoryDTO, newInventory);
			return newInventory;
		}).collect(Collectors.toList());
		
		PurchaseOrder orderInput = PurchaseOrder.builder()
												.receiptNumber(input.getReceiptNumber())
												.inventories(inventories)
												.build();
		
		orderInput.getInventories().forEach(inventory -> {
			inventory.setPurchaseOrder(orderInput);
		});
		
		return orderInput;
	}

}




