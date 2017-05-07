package com.ayyll.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayyll.dao.UserDao;
import com.ayyll.entity.User;
import com.ayyll.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int addUser(String username, String password, String headimg) {
		return userDao.addUser(username, password, headimg);
	}

	@Override
	public User findUser(String username, String password) {
		return userDao.findUser(username, password);
	}

	@Override
	public User getUserByID(Integer uid) {
		return userDao.getUserByID(uid);
	}

	@Override
	public int updateHeadImg(String headImgName, Integer uid) {
		return userDao.updateHeadImg(headImgName, uid);
	}

	@Override
	public int updateUserInfo(Integer uid, String password) {
		return userDao.updateUserInfo(uid, password);
	}

	@Override
	public int updateUserRank(Integer uid, Integer rank, Integer exp,
			String head_title) {
		
		return userDao.updateUserRank(uid, rank, exp, head_title);
	}

}
