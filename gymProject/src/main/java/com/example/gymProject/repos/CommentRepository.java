package com.example.gymProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymProject.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findBySalonId(Long salonId);

}
