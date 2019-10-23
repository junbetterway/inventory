package com.pearlpay.training.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pearlpay.training.entity.PurchaseOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InventoryDTO extends BaseEntityDTO {
	
	private String name;
	private Double price;
	
	@JsonIgnore
	private PurchaseOrder purchaseOrder;

}
