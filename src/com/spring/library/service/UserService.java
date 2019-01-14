package com.spring.library.service;

import java.util.List;

import com.spring.library.model.Authorities;
import com.spring.library.model.Users;

public interface UserService {
	public void addUser(Users user);
	public List<Users> userList();
	public void addAuthority(Authorities authority);
}
