package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Puan;
import com.example.gymProject.entities.Salon;
import com.example.gymProject.entities.Sporcu;
import com.example.gymProject.repos.PuanRepository;
import com.example.gymProject.repos.SalonRepository;
import com.example.gymProject.repos.SporcuRepository;
import com.example.gymProject.requests.PuanCreateRequest;

@Service
public class PuanService {
	private PuanRepository puanRepository;
	private SalonRepository salonRepository;
	private SporcuRepository sporcuRepository;
	
	public PuanService(PuanRepository puanRepository, SalonRepository salonRepository,
			SporcuRepository sporcuRepository) {
		super();
		this.puanRepository = puanRepository;
		this.salonRepository = salonRepository;
		this.sporcuRepository = sporcuRepository;
	}

	public List<Puan> getAllPuan(Optional<Long> salonId) {
		// TODO Auto-generated method stub
		if(salonId.isPresent()) {
			return puanRepository.findBySalonId(salonId.get());
		}
		return puanRepository.findAll();
	}

	public Puan createPuan(PuanCreateRequest puanCreateRequest) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(puanCreateRequest.getSalonId());
		Optional<Sporcu> sporcu = sporcuRepository.findById(puanCreateRequest.getSporcuId());
		if(salon.isPresent() && sporcu.isPresent()) {
			Puan puan = new Puan();
			puan.setId(puanCreateRequest.getId());
			puan.setPuan(puanCreateRequest.getPuan());
			puan.setSalon(salon.get());
			puan.setSporcu(sporcu.get());
			return puanRepository.save(puan);
		}
		return null;
	}

	public Puan getOnePuan(Long puanId) {
		// TODO Auto-generated method stub
		return puanRepository.findById(puanId).orElse(null);
	}

	public Puan updatePuan(Long puanId, Long newPuan) {
		// TODO Auto-generated method stub
		Optional<Puan> puan = puanRepository.findById(puanId);
		if(puan.isPresent()) {
			Puan foundPuan = puan.get();
			foundPuan.setPuan(newPuan);
			puanRepository.save(foundPuan);
			return foundPuan;
		}
		return null;
	}

	public void deletePuan(Long puanId) {
		// TODO Auto-generated method stub
		puanRepository.deleteById(puanId);
	}
	
}
