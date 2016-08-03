package com.niit.shoppingcart.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;




public class SupplierTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier=(Supplier) context.getBean("supplier");
		supplier.setId("S120");
		supplier.setName("SName120");
		supplier.setAddress("chennai");
		
		supplierDAO.saveOrUpdate(supplier);
		
	if(supplierDAO.get("sdfsf") == null)
		{
			System.out.println("Supplier does not exists");
		}
		else
		{
			System.out.println("Supplier exist .. the details are ..");
			System.out.println();
		}
		}
		}
		

