package com.spring.library.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.library.model.Authorities;
import com.spring.library.model.Users;
import com.spring.library.passwordEncoder.PasswordEnCoder;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addUser(Users user) {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		String password = user.getPassword();
		user.setPassword(new PasswordEnCoder().encoder(password));
		user.setEnabled(1);
		currentSession.save(user);
		
	
		
	}

	@Override
	public List<Users> userList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users>getUserQuery = (Query<Users>) currentSession.createQuery("from users");
		List<Users>getUserList=getUserQuery.getResultList();
		return getUserList;
	}

	@Override
	public void addAuthority(Authorities authority) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(authority);
	}

}
