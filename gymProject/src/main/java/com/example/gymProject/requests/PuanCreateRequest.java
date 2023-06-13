package com.example.gymProject.requests;

import lombok.Data;

@Data
public class PuanCreateRequest {
	Long id;
	Long sporcuId;
	Long salonId;
	Long puan;
}
