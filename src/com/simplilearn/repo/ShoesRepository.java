package com.simplilearn.repo;

import java.util.List;

import com.simplilearn.entities.Shoes;

public interface ShoesRepository {

	public void saveOrUpdate(Shoes shoes);

	public void delete(String id);

	public List<Shoes> getById(String id);

	public List<Shoes> getAllShoes();
}
