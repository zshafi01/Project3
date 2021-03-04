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
		return 0;
	}

	@Override
	public List<Shoes> retreveAllShoesInfo() {
		return shoesRepository.getAllShoes();
	}

	@Override
	public Shoes retreveShoesById(String id) {
		List<Shoes> listofshoes = shoesRepository.getById(id);
		if (listofshoes != null && !listofshoes.isEmpty()) {
			return listofshoes.get(0);
		}
		return null;
	}

	@Override
	public boolean saveShoes(Shoes shoes) {
		try {
			shoesRepository.saveOrUpdate(shoes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateShoes(Shoes shoes) {
		try {
			shoesRepository.saveOrUpdate(shoes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteShoes(String id) {

		try {
			shoesRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
