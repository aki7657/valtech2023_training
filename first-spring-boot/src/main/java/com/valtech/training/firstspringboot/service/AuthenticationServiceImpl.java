package com.valtech.training.firstspringboot.service;

import java.sql.Array;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;
import com.valtech.training.firstspringboot.repositories.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void populateUser() {
		RegisterUserModel registerUserModel = new RegisterUserModel();
		registerUserModel.setUsername("Akhil");
		registerUserModel.setPassword("Password");
		createUser(registerUserModel);
		registerUserModel.setUsername("admin");
		registerUserModel.setPassword("admin");
		User user = createUser(registerUserModel);
//		upgradeUserToAdmin(user.getId());
	}

	@Override
	public User createUser(RegisterUserModel registerUserModel) {
		User user = new User(registerUserModel.getUsername(), passwordEncoder.encode(registerUserModel.getPassword()),
				Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
		user.setEnabled(true);
		return userRepo.save(user);
	}

	@Override
	public void upgradeUserToAdmin(long id) {
		User user = userRepo.getReferenceById(id);
		user.addRole("ADMIN");
		userRepo.save(user);

	}

	@Override
	public boolean changePassword(ChangePasswordModel changePasswordModel) {
		User user = userRepo.findByUsername(changePasswordModel.getUsername());
		if (passwordEncoder.matches(changePasswordModel.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(changePasswordModel.getNewPassword()));
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public void enableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(true);
	}

	@Override
	public void disableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(false);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}

}
