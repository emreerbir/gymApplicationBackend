package com.example.gymProject.requests;

import lombok.Data;

@Data
public class SporcuCreateRequest {
	Long id;
	String userName;
	String password;
	Long salonId;
}
