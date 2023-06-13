package com.example.gymProject.requests;

import lombok.Data;

@Data
public class PtUpdateRequest {
	String userName;
	String password;
	Long salonId;
}
