package com.item.app.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.item.app.models.Item;
import com.item.app.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		
		List<Producto> producto = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		
		return producto.stream().map( product -> new Item(product,1)).collect(Collectors.toList());
	}

	@Override
	public Item finById(Long id, Integer cantiadad) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariable);
		return new Item(producto, cantiadad);
	}

}
