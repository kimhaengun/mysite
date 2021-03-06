package com.douzone.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.UserRepository;
import com.douzone.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void join(UserVo vo) {
		// TODO Auto-generated method stub
		userRepository.insert(vo);
	}
	
	public UserVo getUser(Long no) {
		
		return userRepository.findByNo(no);
	}
	
	public UserVo getUser(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	public UserVo getUser(String email, String password) {
		
		return userRepository.findByEmailAndPassword(email,password);
	}

	public void updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		userRepository.update(userVo);
	}


	
}
