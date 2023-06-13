package com.example.gymProject.requests;

import lombok.Data;

@Data
public class ProgramCreateRequest {
	Long id;
	Long ptId;
	Long sporcuId;
	String title;
	String text;
}
