package com.pearlpay.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearlpay.training.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

}
