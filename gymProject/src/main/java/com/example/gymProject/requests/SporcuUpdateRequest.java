package com.example.gymProject.requests;

import lombok.Data;

@Data
public class SporcuUpdateRequest {
	String userName;
	String password;
	Long salonId;
}
