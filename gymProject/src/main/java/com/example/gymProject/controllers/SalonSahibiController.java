package com.example.gymProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymProject.entities.SalonSahibi;
import com.example.gymProject.requests.SalonSahibiCreateRequest;
import com.example.gymProject.requests.SalonSahibiUpdateRequest;
import com.example.gymProject.services.SalonSahibiService;

@RestController
@RequestMapping("/salonsahibi")
public class SalonSahibiController {
	private SalonSahibiService salonSahibiService;

	public SalonSahibiController(SalonSahibiService salonSahibiService) {
		super();
		this.salonSahibiService = salonSahibiService;
	}
	
	@GetMapping
	public List<SalonSahibi> getAllSalonSahibi(@RequestParam Optional<Long> salonId) {
		return salonSahibiService.getAllSalonSahibi(salonId);
	}
	
	@PostMapping
	public SalonSahibi createSalonSahibi(@RequestBody SalonSahibiCreateRequest newSalonSahibiCreateRequest) {
		return salonSahibiService.createSalonSahibi(newSalonSahibiCreateRequest);
	}
	
	@GetMapping("/{salonSahibiId}")
	public SalonSahibi getOneSalonSahibi(@PathVariable Long salonSahibiId) {
		return salonSahibiService.getOneSalonSahibi(salonSahibiId);
	}
	
	@PutMapping("/{salonSahibiId}")
	public SalonSahibi updateSalonSahibi(@PathVariable Long salonSahibiId, @RequestBody SalonSahibiUpdateRequest newSalonSahibiUpdateRequest) {
		return salonSahibiService.updateSalonSahibi(salonSahibiId, newSalonSahibiUpdateRequest);
	}
	
	@DeleteMapping("/{salonSahibiId}")
	public void deleteSalonSahibi(@PathVariable Long salonSahibiId) {
		salonSahibiService.deleteSalonSahibi(salonSahibiId);
	}
	
}
