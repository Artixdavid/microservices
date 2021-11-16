package com.item.app.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.app.clientes.ProductoClienteRest;
import com.item.app.models.Item;

@Service("clienteFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
	}

	@Override
	public Item finById(Long id, Integer cantiadad) {
		return new Item(clienteFeign.detalle(id), cantiadad);
	}

}
