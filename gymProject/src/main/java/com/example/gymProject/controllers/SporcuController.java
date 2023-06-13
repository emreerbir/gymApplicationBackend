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

import com.example.gymProject.services.SporcuService;
import com.example.gymProject.entities.Sporcu;
import com.example.gymProject.requests.SporcuCreateRequest;
import com.example.gymProject.requests.SporcuUpdateRequest;

@RestController
@RequestMapping("/sporcu")
public class SporcuController {
	private SporcuService sporcuService;
	
	public SporcuController(SporcuService sporcuService) {
		super();
		this.sporcuService = sporcuService;
	}

	@GetMapping
	public List<Sporcu> getAllSporcu(@RequestParam Optional<Long> salonId){
		return sporcuService.getAllSporcu(salonId);
	}
	
	@PostMapping
	public Sporcu createSporcu(@RequestBody SporcuCreateRequest sporcuCreateRequest) {
		return sporcuService.createSporcu(sporcuCreateRequest);
	}
	
	@GetMapping("/{sporcuId}")
	public Sporcu getOneSporcu(@PathVariable Long sporcuId) {
		//custom exception
		return sporcuService.getOneSporcu(sporcuId);
	}
	
	@PutMapping("/{sporcuId}")
	public Sporcu updateOneSporcu(@PathVariable Long sporcuId, @RequestBody SporcuUpdateRequest newSporcuUpdateRequest) {
		return sporcuService.updateOneSporcu(sporcuId, newSporcuUpdateRequest);
	}
	
	@DeleteMapping("/{sporcuId}")
	public void deleteOneSporcu(@PathVariable Long sporcuId) {
		sporcuService.deleteOneSporcu(sporcuId);
	}
	
}
