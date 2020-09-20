package com.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Item;
import com.org.repository.ItemRepository;

@Service
public class ItemDAO {
	
	@Autowired
	ItemRepository itemRepository;

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

}
