package org.thcic.xapx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.xapx.dao.UserDao;
import org.thcic.xapx.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Transactional
	public User getUserById(Long user_id) {
		return userDao.getUserById(user_id);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<String> getDemoMenu() {
		List<String> menu = new ArrayList<String>();
		menu.add("读取数据");
		menu.add("校验数据");
		menu.add("菜单三");
		return menu;
	}

}
