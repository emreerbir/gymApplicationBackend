package com.example.gymProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {

	List<Program> findBySporcuId(Long sporcuId);


}
