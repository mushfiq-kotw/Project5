package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RawMaterialOrder")
public class RMController {
	@Autowired
	private RawMaterialOrderRepository rawMaterialOrderRepository;
	
	@GetMapping("PlaceRawMaterialOrder")
	public String placeRMOrder(@RequestBody RMOrderRequest rMOrderRequest)
	{	RawMaterialOrder rm = new RawMaterialOrder();
		rm.setQty(rMOrderRequest.getQty());
		rm.setPricePerUnit(rMOrderRequest.getPricePerUnit());
		rm.setOrderStatus("Processing");
		rawMaterialOrderRepository.save(rm);
		return "Order placed successfully";
	}
	@GetMapping("fetchAllRawMaterialOrders")
	public ResponseEntity<List<RawMaterialOrder>> fetchAllRawMaterialOrders()
	{	return ResponseEntity.ok(rawMaterialOrderRepository.findAll());
	}
	@GetMapping("fetchByOrderId")
	public ResponseEntity<RawMaterialOrder> fetchById(@RequestParam long id)
	{	Optional<RawMaterialOrder> optrmorder= rawMaterialOrderRepository.findById(id);
		if(optrmorder.isPresent())
			return ResponseEntity.ok(optrmorder.get());
		else
			return ResponseEntity.notFound().build();
	}
	@GetMapping("Update")
	public String updateStatus(@RequestBody UpdateRMValues updateRMValues)
	{	RawMaterialOrder rmo = rawMaterialOrderRepository.findById(updateRMValues.getId()).get();
		if(rmo.getOrderStatus().equals("DELIVERED"))
			return "RawMaterial already delivered!";
		if(rmo.getOrderStatus().equals("CANCELLED"))
			return "RawMaterial delivery was cancelled.";
		if(updateRMValues.getStatus().equals("DELIVERED"))
			rmo.setOrderStatus("DELIVERED");
		if(updateRMValues.getStatus().equals("CANCELLED"))
			rmo.setOrderStatus("CANCELLED");
		rawMaterialOrderRepository.save(rmo);
		return "Update successful";
	}

}
