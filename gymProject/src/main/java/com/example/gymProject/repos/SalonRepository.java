package com.example.gymProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.Salon;

public interface SalonRepository extends JpaRepository<Salon, Long> {

}
