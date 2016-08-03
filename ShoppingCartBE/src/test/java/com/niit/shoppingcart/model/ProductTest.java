package com.niit.shoppingcart.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;



public class ProductTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");
		product.setId("P101");
		product.setName("Laptop");
		product.setDescription("PDesc201");
		product.setPrice("10000");
		
		productDAO.saveOrUpdate(product);
		
		if( productDAO.get("sdfsf") ==null)
		{
			System.out.println("Product does not exist");
			}
		else
		{
			System.out.println("Product exist .. the details are ..");
			System.out.println();
			
		}
		

	}

}
