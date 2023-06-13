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

import com.example.gymProject.entities.Puan;
import com.example.gymProject.requests.PuanCreateRequest;
import com.example.gymProject.services.PuanService;

@RestController
@RequestMapping("/puan")
public class PuanController {
	private PuanService puanService;

	public PuanController(PuanService puanService) {
		super();
		this.puanService = puanService;
	}
	
	@GetMapping
	public List<Puan> getAllPuan(@RequestParam Optional<Long> salonId) {
		return puanService.getAllPuan(salonId);
	}
	
	@PostMapping
	public Puan createPuan(@RequestBody PuanCreateRequest puanCreateRequest) {
		return puanService.createPuan(puanCreateRequest);
	}
	
	@GetMapping("/{puanId}")
	public Puan getOnePuan(@PathVariable Long puanId) {
		return puanService.getOnePuan(puanId);
	}
	
	@PutMapping("/{puanId}")
	public Puan updatePuan(@PathVariable Long puanId, @RequestBody Long newPuan) {
		return puanService.updatePuan(puanId, newPuan);
	}
	
	@DeleteMapping("/{puanId}")
	public void deletePuan(@PathVariable Long puanId) {
		puanService.deletePuan(puanId);
	}
}
