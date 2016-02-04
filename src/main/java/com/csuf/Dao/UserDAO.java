package com.csuf.Dao;

import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;

import com.csuf.Model.UserRowMapper;
import com.csuf.Model.Users;

@Controller
public class UserDAO extends JdbcDaoSupport{
	//@Autowired
//	private DataSource dataSource;
	//private JdbcTemplate jdbcTemplate;
	
	
	public int  Count()
	{
		System.out.println("in user dao");
		String sql="select count(*) from information_schema.tables ";
		
		return getJdbcTemplate().queryForInt(sql);
		
	}
	
	
	public int authenticate(Users user){
	 String sql= "select count(*) from users where username= '"+ user.getUserName()+"' and password= '"+user.getPassword()+"'";
		
	 return getJdbcTemplate().queryForInt(sql);
		    
	}
	
public void findAll(){
	
		String sql = "SELECT * FROM users";
		
		@SuppressWarnings("unchecked")
		List<Users> temp= this.getJdbcTemplate().query( sql, new UserRowMapper());
		
		for(Users obj : temp){
			System.out.println(obj.getUserName()+"  this is find all");
		}

      }  
		
	
	
	
	
	

	public int insert(Users user) {
		// TODO Auto-generated method stub
		
		String sql="insert into users values( '"+user.getUserName()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmailid()+"','"+user.getPassword()+"')";
		getJdbcTemplate().update(sql);
		return 1;
	}
	
	
	
	
}
