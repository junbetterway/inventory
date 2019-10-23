package com.pearlpay.training.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class PurchaseOrderDTO extends BaseEntityDTO {

	@JsonProperty("adel")
	private String receiptNumber;
	
	private List<InventoryDTO> inventories;
	
}
