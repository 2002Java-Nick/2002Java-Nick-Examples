package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.example.model.User;
import com.revature.util.ConnectionFactory;

public class UserDaoPostgres implements UserDao {

	@Override
	public void createUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User u) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "update user_table set password = '" + u.getPassword() + "' where username = '" + u.getUsername() + "'";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {

		User ret = null;
		
		String sql = "Select * from user_table where username ='" + username + "'";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new User();
				ret.setId(rs.getInt(1));
				ret.setUsername(rs.getString(2));
				ret.setPassword(rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
