package com.example.maindriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.util.ConnectionFactory;

public class CallableDriver {

	//Callable Statement - used to call Stored Procedures and Functions
	//Unfortunately this does not work for Postgres
	//In Postgres specifically, Stored Procedures are called using prepared statements
	public static void main(String[] args) {
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			conn.setAutoCommit(false);
			
			ResultSet rs = null;
			
			String sql = "call expensive_tracks(?, ?)";
			//CallableStatement call = conn.prepareCall(sql);
			PreparedStatement call = conn.prepareCall(sql);
			call.setDouble(1, 3.5);
			call.setObject(2, rs, Types.OTHER);
			
			ResultSet ret = call.executeQuery();
			
			ret.next();
			
			rs = (ResultSet) ret.getObject(1);
			
			while (rs.next()) {
				System.out.println("Track Title: " + rs.getString(1));
				System.out.println("Unit Price: " + rs.getDouble(2));
				System.out.println("---------------------------------");
			}
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
