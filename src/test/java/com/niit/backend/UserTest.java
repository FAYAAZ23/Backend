package com.niit.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;

public class UserTest {
	
	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
	
	UserDAO userDAO = (UserDAO)  context.getBean("userDAO");
	User u=(User)	  context.getBean("user");
	

	u.setId("TAB_007");
	u.setName("neerja");
	u.setPassword("123456");
	u.setMobile("SAMSUNG");
	u.setMail("neeru@g.com");
	u.setAddress("KPHP");
	
	
	userDAO.saveOrUpdate(u);
	
	userDAO.delete("USR_7");
	userDAO.get("USR_7");
	List<User>  list =    userDAO.list();
	
	for(User usr : list)
	{
		System.out.println(usr.getId()  + ":" +  usr.getName()  + ":"+  usr.getPassword() + ":"+  usr.getMobile() + ":"+  usr.getMail() + ":"+  usr.getAddress());
	}
		
		context.close();
	}

}
