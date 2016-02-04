package com.csuf.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper
	{

	
		@Override
		public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Users user=new Users();
			user.setUserName(rs.getString("username"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmailid(rs.getString("email_id"));
			user.setPassword(rs.getString("password"));
			
			return user;
		}
		
	}

