package com.flexitech.app.portfolio.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.flexitech.app.portfolio.dto.ProjectRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender mailSender;

	@Value("${app.team.email}")
	private String teamEmail;

	@Override
	public void sendProjectInquiry(ProjectRequestDTO request) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(request.getClientEmail());
		message.setTo(teamEmail);
		message.setSubject("★ New Project Inquiry: " + request.getProjectType() + " from " + request.getClientName());

		String emailBody = String.format(
				"Client Name: %s\nEmail: %s\nContact: %s\n\nService: %s\nEstimated Budget: %s\n\nRequirements:\n%s",
				request.getClientName(), request.getClientEmail(),
				request.getClientContact() != null ? request.getClientContact() : "Not provided",
				request.getProjectType(), request.getBudget(), request.getProjectDetails());

		message.setText(emailBody);

		mailSender.send(message);
	}

	@Override
	public void contactUs(String name, String email, String description) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(email);
		message.setTo(teamEmail);
		message.setSubject("★ New General Inquiry from " + name);

		String emailBody = String.format(
				"Sender Name: %s\nEmail Address: %s\n\nMessage / Description:\n%s",
				name, email, description);

		message.setText(emailBody);

		mailSender.send(message);
	}

}