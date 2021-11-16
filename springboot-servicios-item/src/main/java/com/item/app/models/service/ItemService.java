package com.item.app.models.service;

import java.util.List;

import com.item.app.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item finById(Long id, Integer cantiadad);

}
