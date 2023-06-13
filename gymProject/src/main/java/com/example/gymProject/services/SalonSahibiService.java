package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Salon;
import com.example.gymProject.entities.SalonSahibi;
import com.example.gymProject.repos.SalonRepository;
import com.example.gymProject.repos.SalonSahibiRepository;
import com.example.gymProject.requests.SalonSahibiCreateRequest;
import com.example.gymProject.requests.SalonSahibiUpdateRequest;

@Service
public class SalonSahibiService {
	private SalonSahibiRepository salonSahibiRepository;
	private SalonRepository salonRepository;
	
	public SalonSahibiService(SalonSahibiRepository salonSahibiRepository, SalonRepository salonRepository) {
		super();
		this.salonSahibiRepository = salonSahibiRepository;
		this.salonRepository = salonRepository;
	}

	public List<SalonSahibi> getAllSalonSahibi(Optional<Long> salonId) {
		// TODO Auto-generated method stub
		if(salonId.isPresent()) {
			return salonSahibiRepository.findBySalonId(salonId.get());
		}
		return salonSahibiRepository.findAll();
	}

	public SalonSahibi createSalonSahibi(SalonSahibiCreateRequest newSalonSahibiCreateRequest) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(newSalonSahibiCreateRequest.getSalonId().get());
		if(salon.isPresent()) {
			SalonSahibi salonSahibi = new SalonSahibi();
			salonSahibi.setId(newSalonSahibiCreateRequest.getId());
			salonSahibi.setPassword(newSalonSahibiCreateRequest.getPassword());
			salonSahibi.setSalon(salon.get());
			salonSahibi.setUserName(newSalonSahibiCreateRequest.getUserName());
			return salonSahibiRepository.save(salonSahibi);
		}
		SalonSahibi salonSahibi = new SalonSahibi();
		salonSahibi.setId(newSalonSahibiCreateRequest.getId());
		salonSahibi.setPassword(newSalonSahibiCreateRequest.getPassword());
		salonSahibi.setSalon(null);
		salonSahibi.setUserName(newSalonSahibiCreateRequest.getUserName());
		return salonSahibiRepository.save(salonSahibi);
	}

	public SalonSahibi getOneSalonSahibi(Long salonSahibiId) {
		// TODO Auto-generated method stub
		return salonSahibiRepository.findById(salonSahibiId).orElse(null);
	}

	public SalonSahibi updateSalonSahibi(Long salonSahibiId, SalonSahibiUpdateRequest newSalonSahibiUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<SalonSahibi> salonSahibi = salonSahibiRepository.findById(salonSahibiId);
		if(salonSahibi.isPresent()) {
			SalonSahibi foundSalonSahibi = salonSahibi.get();
			foundSalonSahibi.setUserName(newSalonSahibiUpdateRequest.getUserName());
			foundSalonSahibi.setPassword(newSalonSahibiUpdateRequest.getPassword());
			if(newSalonSahibiUpdateRequest.getSalonId().isPresent()) {
				Optional<Salon> salon = salonRepository.findById(newSalonSahibiUpdateRequest.getSalonId().get());
				foundSalonSahibi.setSalon(salon.get());
			}
			salonSahibiRepository.save(foundSalonSahibi);
			return foundSalonSahibi;
		}
		return null;
	}

	public void deleteSalonSahibi(Long salonSahibiId) {
		// TODO Auto-generated method stub
		salonSahibiRepository.deleteById(salonSahibiId);
	}
	
}
