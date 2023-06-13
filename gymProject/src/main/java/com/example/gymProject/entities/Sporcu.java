package com.example.gymProject.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="sporcu")
@Data
public class Sporcu {
	@Id
	Long id;
	
	String userName;
	String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="salon_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
	Salon salon;
}
