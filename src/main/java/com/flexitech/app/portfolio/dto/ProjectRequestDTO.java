package com.flexitech.app.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {
	private String clientName;
    private String clientEmail;
    private String clientContact;
    private String projectType;
    private String budget;
    private String projectDetails;
}
