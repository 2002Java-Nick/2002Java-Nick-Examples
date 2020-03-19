package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.User;
import com.revature.exception.UserInsertionException;
import com.revature.util.ConnectionFactory;

public class UserDAOPostgres implements UserDAO {

	private Connection conn = ConnectionFactory.getConnection();

	private static final String USER_TABLE = "usr";
	private static final String SELECT_USER_BY_USERNAME = "select * from " + USER_TABLE + " where name=?";
	private static final String INSERT_USER = "insert into " + USER_TABLE + " (name, password) values(?, ?)";
	private static final String SELECT_ALL_USERS = "select * from " + USER_TABLE;

	public User getUserByUsername(String username) {
		User user = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_USERNAME);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void createUser(User user) throws UserInsertionException {
		try {
			PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserInsertionException(e);
		}
	}

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
