package com.example.gymProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.SalonSahibi;

public interface SalonSahibiRepository extends JpaRepository<SalonSahibi, Long> {

	List<SalonSahibi> findBySalonId(Long salonId);

}
