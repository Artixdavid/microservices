package com.productos.app.service;

import java.util.List;

import com.productos.app.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
}
