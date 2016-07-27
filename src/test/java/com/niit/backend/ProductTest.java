package com.niit.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.model.Product;

public class ProductTest {
	
	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
	
	ProductDAO productDAO = (ProductDAO)  context.getBean("productDAO");
	Product p=(Product)	  context.getBean("product");
	

	p.setId("POD_006");
	p.setName("CYCLE");
	p.setDescription("vehicle product");
	p.setPrice("5000");
	
	
	productDAO.saveOrUpdate(p);
	
	productDAO.delete("POD_6");
	productDAO.get("POD_6");
	List<Product>  list =    productDAO.list();
	
	for(Product pod : list)
	{
		System.out.println(pod.getId()  + ":" +  pod.getName()  + ":"+  pod.getDescription() + ":" + pod.getPrice());
	}
		
		context.close();
	}

}
