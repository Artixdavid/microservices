package com.productos.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.productos.app.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
	
	

}
