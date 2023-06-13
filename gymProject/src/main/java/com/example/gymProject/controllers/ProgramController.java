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

import com.example.gymProject.entities.Program;
import com.example.gymProject.requests.ProgramCreateRequest;
import com.example.gymProject.requests.ProgramUpdateRequest;
import com.example.gymProject.services.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController {
	private ProgramService programService;

	public ProgramController(ProgramService programService) {
		super();
		this.programService = programService;
	}
	
	@GetMapping
	public List<Program> getAllProgram(@RequestParam Optional<Long> sporcuId) {
		return programService.getAllProgram(sporcuId);
	}
	
	@PostMapping
	public Program createProgram(@RequestBody ProgramCreateRequest programCreateRequest) {
		return programService.createProgram(programCreateRequest);
	}
	
	@GetMapping("{programId}")
	public Program getOneProgram(@PathVariable Long programId) {
		return programService.getOneProgram(programId);
	}
	
	@PutMapping("/{programId}")
	public Program updateProgram(@PathVariable Long programId, @RequestBody ProgramUpdateRequest newProgramUpdateRequest) {
		return programService.updateProgram(programId, newProgramUpdateRequest);
	}
	
	@DeleteMapping("/{programId}")
	public void deleteProgram(@PathVariable Long programId) {
		programService.deleteProgram(programId);
	}
}
