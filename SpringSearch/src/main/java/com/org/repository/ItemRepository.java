package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
