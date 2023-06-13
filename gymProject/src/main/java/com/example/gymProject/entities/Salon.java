package com.example.gymProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="salon")
public class Salon {
	@Id
	Long id;
	Long fiyat;
	String userName;
	Long puan;
	Long puanLength;
	
}
