package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Program;
import com.example.gymProject.entities.Pt;
import com.example.gymProject.entities.Sporcu;
import com.example.gymProject.repos.ProgramRepository;
import com.example.gymProject.repos.PtRepository;
import com.example.gymProject.repos.SporcuRepository;
import com.example.gymProject.requests.ProgramCreateRequest;
import com.example.gymProject.requests.ProgramUpdateRequest;

@Service
public class ProgramService {
	private ProgramRepository programRepository;
	private PtRepository ptRepository;
	private SporcuRepository sporcuRepository;
	

	public ProgramService(ProgramRepository programRepository, PtRepository ptRepository, SporcuRepository sporcuRepository) {
		super();
		this.programRepository = programRepository;
		this.ptRepository = ptRepository;
		this.sporcuRepository = sporcuRepository;
	}

	public List<Program> getAllProgram(Optional<Long> sporcuId) {
		// TODO Auto-generated method stub
		if(sporcuId.isPresent()) {
			return programRepository.findBySporcuId(sporcuId.get());
		}
		return programRepository.findAll();
	}

	public Program createProgram(ProgramCreateRequest programCreateRequest) {
		// TODO Auto-generated method stub
		Optional<Pt> pt = ptRepository.findById(programCreateRequest.getPtId());
		Optional<Sporcu> sporcu = sporcuRepository.findById(programCreateRequest.getSporcuId());
		if(pt.isPresent() && sporcu.isPresent()) {
			Program program =  new Program();
			program.setId(programCreateRequest.getId());
			program.setPt(pt.get());
			program.setSporcu(sporcu.get());
			program.setText(programCreateRequest.getText());
			program.setTitle(programCreateRequest.getTitle());
			return programRepository.save(program);
		}
		return null;
	}

	public Program getOneProgram(Long programId) {
		// TODO Auto-generated method stub
		return programRepository.findById(programId).orElse(null);
	}

	public Program updateProgram(Long programId, ProgramUpdateRequest newProgramUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<Program> program = programRepository.findById(programId);
		if(program.isPresent()) {
			Program foundProgram = program.get();
			foundProgram.setText(newProgramUpdateRequest.getText());
			foundProgram.setTitle(newProgramUpdateRequest.getTitle());
			programRepository.save(foundProgram);
			return foundProgram;
		}
		return null;
	}

	public void deleteProgram(Long programId) {
		// TODO Auto-generated method stub
		programRepository.deleteById(programId);
	}

	
}
