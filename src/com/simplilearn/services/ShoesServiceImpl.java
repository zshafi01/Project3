package com.simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entities.Shoes;
import com.simplilearn.repo.ShoesRepository;

@Service
public class ShoesServiceImpl implements ShoesService {

	@Autowired
	private ShoesRepository shoesRepository;
	
	@Override
	public long retreveShoesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Shoes> retreveAllShoesInfo() {
		// TODO Auto-generated method stub
		return shoesRepository.getShoes();
	}

	@Override
	public Shoes retreveShoesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveShoes(Shoes shoes) {
		try {
		  shoesRepository.saveOrUpdate(shoes);
		  return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public void updateShoes(Shoes shoes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShoes(String id) {
		// TODO Auto-generated method stub
		
	}

}
