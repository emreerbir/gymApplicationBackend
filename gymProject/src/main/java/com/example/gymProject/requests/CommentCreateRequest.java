package com.example.gymProject.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
	Long id;
	Long sporcuId;
	Long salonId;
	String title;
	String text;
}
