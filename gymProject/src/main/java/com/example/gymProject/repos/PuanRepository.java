package com.example.gymProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.Puan;

public interface PuanRepository extends JpaRepository<Puan, Long> {

	List<Puan> findBySalonId(Long salonId);

}
