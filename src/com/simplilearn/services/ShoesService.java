package com.simplilearn.services;

import java.util.List;

import com.simplilearn.entities.Shoes;

public interface ShoesService {

	public long retreveShoesCount();

	public List<Shoes> retreveAllShoesInfo();

	public Shoes retreveShoesById(String id);

	public boolean saveShoes(Shoes shoes);

	public boolean updateShoes(Shoes shoes);

	public boolean deleteShoes(String id);

}
