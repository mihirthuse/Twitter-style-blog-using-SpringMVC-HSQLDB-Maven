package com.csuf.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.csuf.Model.Blog;
import com.csuf.Model.BlogRowMapper;
 

@Component 
public class BlogDAO extends JdbcDaoSupport {
	
	
	public int  Count()
	{
		
		String sql="select count(*) from blog";
	return	getJdbcTemplate().queryForInt(sql);
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Blog> findAll(){
		
		String sql = "SELECT * FROM blog order by blogid desc ";
		
		return this.getJdbcTemplate().query( sql, new BlogRowMapper());
		
      }  
	
	

	

	@SuppressWarnings("unchecked")
	public List<Blog> findAll(String username) {
	
		String sql = "SELECT * FROM blog where username='"+username+"' order by blogid desc";
		
		return this.getJdbcTemplate().query( sql, new BlogRowMapper());
		
		
		
	}


	public void insert(Blog newblog) {
		
		String sql="insert into blog values('"+newblog.getBlogid()+"','"+newblog.getUserName()+"','"+newblog.getTitle()+"','"+newblog.getDescription()+"','"+newblog.getDate()+"')";
		getJdbcTemplate().update(sql);
		
	}

}
