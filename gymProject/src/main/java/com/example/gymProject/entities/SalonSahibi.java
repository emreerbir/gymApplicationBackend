package com.example.gymProject.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="salonSahibi")
@Data
public class SalonSahibi {
	@Id
	Long id;
	
	String userName;
	String password;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="salon_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Salon salon;
}
