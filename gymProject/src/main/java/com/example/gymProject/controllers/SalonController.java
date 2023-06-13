package com.example.gymProject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymProject.entities.Salon;
import com.example.gymProject.services.SalonService;

@RestController
@RequestMapping("/salon")
public class SalonController {
	private SalonService salonService;

	public SalonController(SalonService salonService) {
		super();
		this.salonService = salonService;
	}
	
	@GetMapping
	public List<Salon> getAllSalon() {
		return salonService.getAllSalon();
	}
	
	@PostMapping
	public Salon createSalon(@RequestBody Salon salon) {
		return salonService.createSalon(salon);
	}
	
	@GetMapping("/{salonId}")
	public Salon getOneSalon(@PathVariable Long salonId) {
		return salonService.getOneSalon(salonId);
	}
	
	@GetMapping("/{salonId}/puan-ortalama")
	public Long getPuanOrtalama(@PathVariable Long salonId) {
		return salonService.getPuanOrtalama(salonId);
	}
	
	@PutMapping("/{salonId}")
	public Salon updateSalon(@PathVariable Long salonId, @RequestBody Long newFiyat) {
		return salonService.updateSalon(salonId, newFiyat);
	}
	
	@PutMapping("/{salonId}/puan")
	public Salon updatePuan(@PathVariable Long salonId, @RequestBody Long puan) {
		return salonService.updatePuam(salonId, puan);
	}
	
	@DeleteMapping("/{salonId}")
	public void deleteSalon(@PathVariable Long salonId) {
		salonService.deleteSalon(salonId);
	}
}
