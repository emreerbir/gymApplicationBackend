package com.example.gymProject.requests;

import lombok.Data;

@Data
public class PtCreateRequest {
	Long id;
	String userName;
	String password;
	Long salonId;
}
