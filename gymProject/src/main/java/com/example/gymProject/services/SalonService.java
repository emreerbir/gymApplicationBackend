package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Salon;
import com.example.gymProject.repos.SalonRepository;

@Service
public class SalonService {
	private SalonRepository salonRepository;

	public SalonService(SalonRepository salonRepository) {
		super();
		this.salonRepository = salonRepository;
	}

	public List<Salon> getAllSalon() {
		// TODO Auto-generated method stub
		return salonRepository.findAll();
	}

	public Salon createSalon(Salon salon) {
		// TODO Auto-generated method stub
		return salonRepository.save(salon);
	}

	public Salon getOneSalon(Long salonId) {
		// TODO Auto-generated method stub
		return salonRepository.findById(salonId).orElse(null);
	}

	public Salon updateSalon(Long salonId, Long newFiyat) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(salonId);
		if(salon.isPresent()) {
			Salon foundSalon = salon.get();
			foundSalon.setFiyat(newFiyat);
			salonRepository.save(foundSalon);
			return foundSalon;
		}
		return null;
	}

	public void deleteSalon(Long salonId) {
		// TODO Auto-generated method stub
		salonRepository.deleteById(salonId);
	}

	public Salon updatePuam(Long salonId, Long puan) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(salonId);
		if(salon.isPresent()) {
			Salon foundSalon = salon.get();
			foundSalon.setPuan(foundSalon.getPuan()+puan);
			foundSalon.setPuanLength(foundSalon.getPuanLength()+1);
			salonRepository.save(foundSalon);
			return foundSalon;
		}
		return null;
	}

	public Long getPuanOrtalama(Long salonId) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(salonId);
		if(salon.isPresent()) {
			Long ortalama = (long) 0;
			ortalama = salon.get().getPuan()/salon.get().getPuanLength();
			return ortalama;
			
		}
		return null;
	}
	
}
