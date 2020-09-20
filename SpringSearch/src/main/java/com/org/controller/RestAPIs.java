package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.ItemDAO;
import com.org.model.Item;

@RestController
@RequestMapping("/api/customer")
public class RestAPIs {
	
	@Autowired
	private ItemDAO itemDao;
	
	@GetMapping(value = "/allnew")
	public List<Item> getResourcenew() {
		return itemDao.findAll();
	}
}