package com.csuf.Controller;


import java.util.Date;
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

import com.csuf.Dao.BlogDAO;
import com.csuf.Dao.UserDAO;
import com.csuf.Model.Blog;
import com.csuf.Model.Users;

@Controller
public class BlogController {

	
	 
    ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	BlogDAO blogdao =  (BlogDAO) ctx.getBean("blogDao", BlogDAO.class);
	UserDAO userdao =  (UserDAO) ctx.getBean("userDao", UserDAO.class);
	
	

	 @RequestMapping(value = "/addpost", method = RequestMethod.POST)
	 public ModelAndView addblog( @ModelAttribute Blog blog , Model model,HttpServletRequest request) {
	 
	 
		 HttpSession session = request.getSession();
			String username=(String) session.getAttribute("username");
		 System.out.println("im in blog post of post"+username);
		 System.out.println(blog.getTitle());
		 blog.setUserName(username);
		 blog.setBlogid((blogdao.Count()+1));
		 Date date = new Date();
		  String dd=date.toString();
		  blog.setDate(dd);
		  blogdao.insert(blog);
		 
		 
		 model.addAttribute("username",username );
		 List<Blog> blogdatabase = blogdao.findAll();
		   model.addAttribute("blogdatabase",blogdatabase );
		   model.addAttribute("Blog", new Blog());
		 return new ModelAndView("userhome", "command", model);
	
	//returns the view name
	  
   	
	  

	 }
	@RequestMapping(value={"/", "/blog"})
	
	 public ModelAndView publichomepage( Model model) {
		  // Map<String, Object> model = new HashMap<String, Object>();
		List<Blog> blogdatabase = blogdao.findAll();
	   model.addAttribute("blogdatabase",blogdatabase );
	   //returns the view name
	   return new ModelAndView("publichome", "command", model);

	 }
	@RequestMapping(value={"/myblog"})
	
	 public ModelAndView myblogpage(@RequestParam(value="action") String action, Model model,HttpServletRequest request) {
		  // Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("username");
		
		List<Blog> blogdatabase = blogdao.findAll(username);
	   model.addAttribute("blogdatabase",blogdatabase );
	   model.addAttribute("username",username );
	   //returns the view name
	   model.addAttribute("Blog", new Blog());
	   if(username==null)
		   return new ModelAndView("publichome", "command", model);
	   else
		   return new ModelAndView("userhome", "command", model);

	 }
	
	
	@RequestMapping(value={"/userblog"})
	
	 public ModelAndView userblogpage(@RequestParam(value="action") String action, Model model,HttpServletRequest request) {
		  // Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("username");
		
		List<Blog> blogdatabase = blogdao.findAll();
	   model.addAttribute("blogdatabase",blogdatabase );
	   //returns the view name
	   model.addAttribute("Blog", new Blog());
	   model.addAttribute("username",username );
	   if(username==null)
		   return new ModelAndView("publichome", "command", model);
	   else
		   return new ModelAndView("userhome", "command", model);

	 }

}
