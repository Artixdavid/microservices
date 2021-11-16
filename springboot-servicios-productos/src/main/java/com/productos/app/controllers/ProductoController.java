package com.productos.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productos.app.models.entity.Producto;
import com.productos.app.service.IProductoService;

@RestController
public class ProductoController {
	

	@Autowired
	private Environment env;
	
	@Autowired
	private IProductoService productoServices;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoServices.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoServices.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		
		/* para probar posibles fallos.
		 * 
		 * try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		boolean ok = false;
		if(!ok) {
			throw new RuntimeException("No se pudo cargar el producto");
		}
		*/
		return producto;
	}

}
