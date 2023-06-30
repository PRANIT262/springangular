package com.pranitproject.service;

import java.util.List;

import com.pranitproject.Exception.UserDefineException;
import com.pranitproject.entity.FacebookUser;

public interface FacebookServiceInterface {

	FacebookUser createProfile(FacebookUser fb);

	FacebookUser viewProfile(String email) throws UserDefineException;

	void editProfile(FacebookUser fb);

	void deleteProfile(String em);

	FacebookUser loginUserService(String email, String password);

	List<FacebookUser> getAll();


}
