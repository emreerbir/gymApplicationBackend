package com.example.gymProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymProject.entities.Comment;
import com.example.gymProject.entities.Salon;
import com.example.gymProject.entities.Sporcu;
import com.example.gymProject.repos.CommentRepository;
import com.example.gymProject.repos.SalonRepository;
import com.example.gymProject.repos.SporcuRepository;
import com.example.gymProject.requests.CommentCreateRequest;
import com.example.gymProject.requests.CommentUpdateRequest;

@Service
public class CommentService {
	private CommentRepository commentRepository;
	private SporcuRepository sporcuRepository;
	private SalonRepository salonRepository;
	
	public CommentService(CommentRepository commentRepository, SalonRepository salonRepository, SporcuRepository sporcuRepository) {
		super();
		this.commentRepository = commentRepository;
		this.sporcuRepository = sporcuRepository;
		this.salonRepository = salonRepository;
	}

	public List<Comment> getAllComments(Optional<Long> salonId) {
		// TODO Auto-generated method stub
		if(salonId.isPresent()) {
			return commentRepository.findBySalonId(salonId.get());
		}
		return commentRepository.findAll();
	}

	public Comment createComment(CommentCreateRequest commentCreateRequest) {
		// TODO Auto-generated method stub
		Optional<Sporcu> sporcu = sporcuRepository.findById(commentCreateRequest.getSporcuId());
		Optional<Salon> salon = salonRepository.findById(commentCreateRequest.getSalonId());
		if(salon.isPresent() && sporcu.isPresent()) {
			Comment comment = new Comment();
			comment.setId(commentCreateRequest.getId());
			comment.setSalon(salon.get());
			comment.setSporcu(sporcu.get());
			comment.setText(commentCreateRequest.getText());
			comment.setTitle(commentCreateRequest.getTitle());
			return commentRepository.save(comment);
		}
		return null;
	}

	public Comment getOneComment(Long commentId) {
		// TODO Auto-generated method stub
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment updateComment(Long commentId, CommentUpdateRequest newCommentUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<Comment> comment = commentRepository.findById(commentId);

		if(comment.isPresent()) {
			Comment foundComment = comment.get();
			foundComment.setTitle(newCommentUpdateRequest.getTitle());
			foundComment.setText(newCommentUpdateRequest.getText());
			commentRepository.save(foundComment);
			return foundComment;
		}
		return null;
	}

	public void deleteComment(Long commentId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(commentId);
	}

}
