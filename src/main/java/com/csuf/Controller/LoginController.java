package com.csuf.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csuf.Dao.BlogDAO;
import com.csuf.Dao.UserDAO;
import com.csuf.Model.Blog;
import com.csuf.Model.Users;

@Controller
public class LoginController {
	
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	UserDAO userdao =  (UserDAO) ctx.getBean("userDao", UserDAO.class);
	BlogDAO blogdao =  (BlogDAO) ctx.getBean("blogDao", BlogDAO.class);

	/*HttpServletRequest request;
	HttpSession session = request.getSession();*/


	
	 
	 @RequestMapping(value = "/signup", method = RequestMethod.POST)
	 	 public String adduser( @ModelAttribute Users user , Model model) {
		  System.out.println(user.getFirstName());
		   System.out.println("im in sign up post");
		   userdao.insert(user);
		
		//returns the view name
		   model.addAttribute("msg","User Added Successfully" );
	    	
		   return "login";

		 }
	 
	 @RequestMapping("signup")
	 public String signup( Model model) {
	  
		 model.addAttribute("Users", new Users());
		 

	   //returns the view name
	   return "signup";

	 }
	 

		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		 public ModelAndView authenticate( @RequestParam(value="username") String username, @RequestParam(value="password") String password, Model model,HttpServletRequest request ) {
			  
			 Users temp = new Users();
	         temp.setUserName(username);
	         temp.setPassword(password);
	         int i=userdao.authenticate(temp);
	    	if(i!=1)
	    	{
	    		 model.addAttribute("msg","Authentication Failed" );
	    		 return new ModelAndView("login", "command", model);
	    			
	    	}
	    	else
	    	{
	    		  // Map<String, Object> model = new HashMap<String, Object>();
	    		HttpSession session = request.getSession();
	    		session.setAttribute("username", username);
    			request.changeSessionId();
	    		List<Blog> blogdatabase = blogdao.findAll();
	    	   model.addAttribute("blogdatabase",blogdatabase );
	    	   model.addAttribute("username",username );
	    	   //returns the view name
	    	   model.addAttribute("Blog", new Blog());
	    	   return new ModelAndView("/userhome", "command", model);
	    	}
					
			  

			 }
		 @RequestMapping("/login")
		 public String login( Model model ) {
		  
		   
		   //returns the view name
				
		   return "/login";

		 }
		 
		 @RequestMapping("/logout")
		 public String logout( Model model,HttpServletRequest request ) {
		  
		   
		   //returns the view name
			 HttpSession session = request.getSession();
			  session.invalidate();
			 List<Blog> blogdatabase = blogdao.findAll();
	    	   model.addAttribute("blogdatabase",blogdatabase );

		   return "/publichome";

		 }
}
