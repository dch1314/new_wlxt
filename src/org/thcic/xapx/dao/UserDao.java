package org.thcic.xapx.dao;

import java.util.List;

import org.thcic.xapx.domain.User;

public interface UserDao {

	User getUserById(Long user_id);

	List<User> getAllUsers();

}
