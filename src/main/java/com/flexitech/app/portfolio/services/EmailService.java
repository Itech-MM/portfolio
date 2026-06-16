package com.flexitech.app.portfolio.services;

import com.flexitech.app.portfolio.dto.ProjectRequestDTO;

public interface EmailService {
	void sendProjectInquiry(ProjectRequestDTO request);
}
