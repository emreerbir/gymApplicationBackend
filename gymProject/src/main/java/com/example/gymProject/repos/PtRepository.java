package com.example.gymProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.Pt;

public interface PtRepository extends JpaRepository<Pt, Long> {

	List<Pt> findBySalonId(Long salonId);
	
	
}
