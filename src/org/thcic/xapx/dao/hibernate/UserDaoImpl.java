package org.thcic.xapx.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thcic.xapx.dao.UserDao;
import org.thcic.xapx.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserById(Long user_id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,
				user_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		return criteria.list();
	}

}
