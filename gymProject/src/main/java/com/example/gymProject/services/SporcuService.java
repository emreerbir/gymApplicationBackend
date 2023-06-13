package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Salon;
import com.example.gymProject.entities.Sporcu;
import com.example.gymProject.repos.SalonRepository;
import com.example.gymProject.repos.SporcuRepository;
import com.example.gymProject.requests.SporcuCreateRequest;
import com.example.gymProject.requests.SporcuUpdateRequest;

@Service
public class SporcuService {
	SporcuRepository sporcuRepository;
	SalonRepository salonRepository;
	public SporcuService(SporcuRepository sporcuRepository) {
		super();
		this.sporcuRepository = sporcuRepository;
	}
	
	public List<Sporcu> getAllSporcu(Optional<Long> salonId) {
		if(salonId.isPresent()) {
			return sporcuRepository.findBySalonId(salonId.get());
		}
		return sporcuRepository.findAll();
	}

	public Sporcu createSporcu(SporcuCreateRequest sporcuCreateRequest) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(sporcuCreateRequest.getSalonId());
		Sporcu sporcu = new Sporcu();
		if(salon.isPresent()) {
			sporcu.setId(sporcuCreateRequest.getId());
			sporcu.setPassword(sporcuCreateRequest.getPassword());
			sporcu.setSalon(salon.get());
			sporcu.setUserName(sporcuCreateRequest.getUserName());
			return sporcuRepository.save(sporcu);
		}
		sporcu.setId(sporcuCreateRequest.getId());
		sporcu.setPassword(sporcuCreateRequest.getPassword());
		sporcu.setSalon(null);
		sporcu.setUserName(sporcuCreateRequest.getUserName());
		return sporcuRepository.save(sporcu);
	}

	public Sporcu getOneSporcu(Long sporcuId) {
		// TODO Auto-generated method stub
		return sporcuRepository.findById(sporcuId).orElse(null);
	}

	public Sporcu updateOneSporcu(Long sporcuId, SporcuUpdateRequest newSporcuUpdateRequest) {
		Optional<Salon> salon = salonRepository.findById(newSporcuUpdateRequest.getSalonId());
		Optional<Sporcu> sporcu = sporcuRepository.findById(sporcuId);
		
		if(salon.isPresent() && sporcu.isPresent()) {
			Sporcu foundSporcu = sporcu.get();
			foundSporcu.setUserName(newSporcuUpdateRequest.getUserName());
			foundSporcu.setPassword(newSporcuUpdateRequest.getPassword());
			foundSporcu.setSalon(salon.get());
			sporcuRepository.save(foundSporcu);
			return foundSporcu;
		}else if(sporcu.isPresent()) {
			Sporcu foundSporcu = sporcu.get();
			foundSporcu.setUserName(newSporcuUpdateRequest.getUserName());
			foundSporcu.setPassword(newSporcuUpdateRequest.getPassword());
			foundSporcu.setSalon(null);
			sporcuRepository.save(foundSporcu);
			return foundSporcu;
		}return null;
	}

	public void deleteOneSporcu(Long sporcuId) {
		// TODO Auto-generated method stub
		sporcuRepository.deleteById(sporcuId);
	}
	
}
