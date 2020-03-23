package com.revature.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.User;
import com.revature.exception.UserInsertionException;

@Component
public class UserDAOHibernate implements UserDAO {

	private SessionFactory sf;

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public User getUserByUsername(String username) {
		Session sess = sf.openSession();
		return sess.get(User.class, username);
	}

	public void createUser(User user) throws UserInsertionException {
		try {	Session sess = sf.openSession();
			Transaction tx = sess.beginTransaction();
			sess.save(user);
			tx.commit();
			sess.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new UserInsertionException(e);
		}
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
