package com.example.gymProject.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="program")
public class Program {
	@Id
	Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pt_id", nullable=false)
	Pt pt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sporcu_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Sporcu sporcu;
	
	String title;
	
	@Lob
	@Column(columnDefinition="text")
	String text;
}
