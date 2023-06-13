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

import com.example.gymProject.entities.Pt;
import com.example.gymProject.requests.PtCreateRequest;
import com.example.gymProject.requests.PtUpdateRequest;
import com.example.gymProject.services.PtService;

@RestController
@RequestMapping("/pt")
public class PtController {
	private PtService ptService;

	public PtController(PtService ptService) {
		super();
		this.ptService = ptService;
	}
	
	@GetMapping
	public List<Pt> getAllPt(@RequestParam Optional<Long> salonId) {
		return ptService.getAllPt(salonId);
	}
	
	@PostMapping
	public Pt createPt(@RequestBody PtCreateRequest ptCreateRequest) {
		return ptService.createPt(ptCreateRequest);
	}
	
	@GetMapping("/{ptId}")
	public Pt getOnePt(@PathVariable Long ptId) {
		return ptService.getOnePt(ptId);
	}
	
	@PutMapping("/{ptId}")
	public Pt updatePt(@PathVariable Long ptId, @RequestBody PtUpdateRequest newPtUpdateRequest) {
		return ptService.updatePt(ptId, newPtUpdateRequest);
	}
	
	@DeleteMapping("/{ptId}")
	public void deletePt(@PathVariable Long ptId) {
		ptService.deletePt(ptId);
	}
	
	
	
	
	
	
	
	
	
	
	
}
