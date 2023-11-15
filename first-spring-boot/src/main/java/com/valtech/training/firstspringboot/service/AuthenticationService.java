package com.valtech.training.firstspringboot.service;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;

public interface AuthenticationService {

	User createUser(RegisterUserModel registerUserModel);

	void upgradeUserToAdmin(long id);

	boolean changePassword(ChangePasswordModel changePasswordModel);

	void enableUser(long id);

	void disableUser(long id);

}