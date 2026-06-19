package com.flexitech.app.portfolio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flexitech.app.portfolio.dto.ProjectRequestDTO;
import com.flexitech.app.portfolio.services.EmailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WelcomeController extends BasedController{
	
	private final EmailService emailService;

    @GetMapping
    public String home(){
        return "pages/home";
    }
    
    @GetMapping("/start-project")
    public String starProjectStep() {
    	return "pages/start-project";
    }
    
    @PostMapping("/start-project")
    @ResponseBody
    public ResponseEntity<String> handleProjectSubmit(@ModelAttribute ProjectRequestDTO request) {
        emailService.sendProjectInquiry(request);
        
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/project-success")
    public String projectSuccess() {
        return "pages/project-success";
    }
    
    @PostMapping("/contact")
    @ResponseBody
    public ResponseEntity<String> contactSubmit(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String description) {
        
        emailService.contactUs(name, email, description);
        return ResponseEntity.ok("Success");
    }
}
