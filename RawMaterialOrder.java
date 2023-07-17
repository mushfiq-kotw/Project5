package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class RawMaterialOrder {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long rawMaterialOrderId;
	private double qty;
	private double pricePerUnit;
	private String orderStatus;

	
	
	
	
	public long getRawMaterialOrderId() {
		return rawMaterialOrderId;
	}
	public void setRawMaterialOrderId(long rawMaterialOrderId) {
		this.rawMaterialOrderId = rawMaterialOrderId;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
