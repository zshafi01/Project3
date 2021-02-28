package com.simplilearn.repo;

import java.util.List;

import com.simplilearn.entities.Shoes;

public interface ShoesRepository {
	
	
	public void saveOrUpdate(Shoes shoes);
    
    public void delete(int shoesId);
    
    public Shoes get(int shoesId);
     
    public List<Shoes> getShoes();
}
