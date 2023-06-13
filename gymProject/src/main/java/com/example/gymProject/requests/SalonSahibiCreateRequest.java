package com.example.gymProject.requests;

import java.util.Optional;

import lombok.Data;

@Data
public class SalonSahibiCreateRequest {
	Long id;
	String userName;
	String password;
	Optional<Long> salonId;
}
