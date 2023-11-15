package com.valtech.training.firstspringboot.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;
import com.valtech.training.firstspringboot.repositories.UserRepo;
import com.valtech.training.firstspringboot.service.AuthenticationService;

@Controller
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute ChangePasswordModel changePasswordModel, Model model) {
		changePasswordModel.setUsername(userDetails.getUsername());
		if (Objects.equals(changePasswordModel.getNewPassword(), changePasswordModel.getConfirmNewPassword())) {
			if (authenticationService.changePassword(changePasswordModel)) {
				model.addAttribute("message", "Passwords changed successfully");
			} else {
				model.addAttribute("message", "Old password does not match");
			}
		} else {
			model.addAttribute("message", "Both the passwords do not match");
			return "changePassword";
		}
		return "redirect:logout";
	}

	@GetMapping("/changePassword")
	public String changePasswordForm() {
		return "changePassword";
	}

	@PostMapping("/registration")
	public String handleRegistration(@ModelAttribute RegisterUserModel registerUserModel, Model model) {
//		if (registerUserModel.getPassword().equals(registerUserModel.getConfirmPassword())) {
		if (Objects.equals(registerUserModel.getPassword(), registerUserModel.getConfirmPassword())) {
			authenticationService.createUser(registerUserModel);
			model.addAttribute("message", "User registration is successful, please proceed to login");
		} else {
			model.addAttribute("message", "Both the passwords do not match, please register again");
			return "registration";
		}
		return "logout";
	}

	@GetMapping("/registration")
	public String registrationForm() {
		return "registration";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/anonymous")
	@ResponseBody
	public String anonymousUserPage() {
		return "Anonymous User Page";
	}

	@GetMapping("/user")
	@ResponseBody
//	return name of the page as the data inputed
	public String userPage() {
		return "User Page";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";
	}

}
