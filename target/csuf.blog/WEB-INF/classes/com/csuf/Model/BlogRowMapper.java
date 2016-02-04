package com.csuf.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BlogRowMapper implements RowMapper {

	@Override
	public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Blog blog=new Blog();
		
		blog.setUserName(rs.getString("username"));
		blog.setTitle(rs.getString("title"));
		blog.setDescription(rs.getString("description"));
		blog.setDate(rs.getString("date"));
		blog.setBlogid(rs.getInt("blogid"));
		
		return blog;
	}
	
}
