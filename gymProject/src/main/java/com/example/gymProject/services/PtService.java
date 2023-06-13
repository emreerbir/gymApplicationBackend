package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Pt;
import com.example.gymProject.entities.Salon;
import com.example.gymProject.repos.PtRepository;
import com.example.gymProject.repos.SalonRepository;
import com.example.gymProject.requests.PtCreateRequest;
import com.example.gymProject.requests.PtUpdateRequest;

@Service
public class PtService {
	private PtRepository ptRepository;
	private SalonRepository salonRepository;
	
	public PtService(PtRepository ptRepository, SalonRepository salonRepository) {
		super();
		this.ptRepository = ptRepository;
		this.salonRepository = salonRepository;
	}

	public List<Pt> getAllPt(Optional<Long> salonId) {
		// TODO Auto-generated method stub
		if(salonId.isPresent()) {
			return ptRepository.findBySalonId(salonId.get());
		}
		return ptRepository.findAll();
	}

	public Pt createPt(PtCreateRequest ptCreateRequest) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonRepository.findById(ptCreateRequest.getSalonId());
		if(salon.isPresent()) {
			Pt pt = new Pt();
			pt.setId(ptCreateRequest.getId());
			pt.setPassword(ptCreateRequest.getPassword());
			pt.setSalon(salon.get());
			pt.setUserName(ptCreateRequest.getUserName());
			return ptRepository.save(pt);
		}
		return null;
	}

	public Pt getOnePt(Long ptId) {
		// TODO Auto-generated method stub
		return ptRepository.findById(ptId).orElse(null);
	}

	public Pt updatePt(Long ptId, PtUpdateRequest newPtUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<Pt> pt = ptRepository.findById(ptId);
		Optional<Salon> salon = salonRepository.findById(newPtUpdateRequest.getSalonId());
		if(pt.isPresent() && salon.isPresent()) {
			Pt foundPt = pt.get();
			foundPt.setUserName(newPtUpdateRequest.getUserName());
			foundPt.setPassword(newPtUpdateRequest.getPassword());
			foundPt.setSalon(salon.get());
			ptRepository.save(foundPt);
			return foundPt;
		}
		return null;
	}

	public void deletePt(Long ptId) {
		// TODO Auto-generated method stub
		ptRepository.deleteById(ptId);
	}
	
}
