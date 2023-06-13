package com.example.gymProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.Sporcu;

public interface SporcuRepository extends JpaRepository<Sporcu, Long> {

	List<Sporcu> findBySalonId(Long salonId);


}
