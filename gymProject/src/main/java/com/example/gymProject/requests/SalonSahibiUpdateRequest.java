package com.example.gymProject.requests;

import java.util.Optional;

import lombok.Data;

@Data
public class SalonSahibiUpdateRequest {
	String userName;
	String password;
	Optional<Long> salonId;
}
