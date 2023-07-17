package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RawMaterialOrderRepository extends CrudRepository<RawMaterialOrder, Long>{
	Optional<RawMaterialOrder> findById(long id);
	List<RawMaterialOrder> findAll();

}
