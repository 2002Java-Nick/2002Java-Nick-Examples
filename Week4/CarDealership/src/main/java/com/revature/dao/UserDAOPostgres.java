package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.ConnectionFactory;

public class UserDAOPostgres implements UserDAO {

	private Connection conn = ConnectionFactory.getConnection();

	private static final String USER_TABLE = "usr";
	private static final String SELECT_USER_BY_USERNAME = "select * from " + USER_TABLE + " where name=?";

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

}
