package com.example.gymProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymProject.entities.Comment;
import com.example.gymProject.requests.CommentCreateRequest;
import com.example.gymProject.requests.CommentUpdateRequest;
import com.example.gymProject.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> salonId) {
		return commentService.getAllComments(salonId);
	}
	
	@PostMapping
	public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest) {
		return commentService.createComment(commentCreateRequest);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneComment(commentId);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest newCommentUpdateRequest) {
		return commentService.updateComment(commentId, newCommentUpdateRequest);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
	}
}
