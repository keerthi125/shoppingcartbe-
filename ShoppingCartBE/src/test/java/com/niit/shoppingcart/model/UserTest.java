package com.niit.shoppingcart.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;

public class UserTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		user.setId("U10");
		user.setName("praveen");
		user.setPassword("*****");
		user.setMobile("9291400818");
		user.setEmail("k123@gmail.com");
		user.setAddress("chennai");
		
		userDAO.saveOrUpdate(user);
		
		if( userDAO.get("sdfsf") ==null)
		{
		System.out.println("User does not exist");
		}
		else
		{
			System.out.println("User exist .. the details are ..");
			System.out.println();
		}
		}
		
	}
	


