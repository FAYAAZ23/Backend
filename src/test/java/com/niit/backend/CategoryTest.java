package com.niit.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.model.Category;

public class CategoryTest {
	
	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
	
	CategoryDAO categoryDAO = (CategoryDAO)  context.getBean("categoryDAO");
	Category c=(Category)	  context.getBean("category");
	

	c.SetId("TAB_006");
	c.setName("LAPTOP");
	c.setDescription("laptop product");
	
	
	categoryDAO.saveOrUpdate(c);
	
	categoryDAO.delete("CAT_3");
	categoryDAO.get("CAT_3");
	List<Category>  list =    categoryDAO.list();
	
	for(Category cat : list)
	{
		System.out.println(cat.getId()  + ":" +  cat.getName()  + ":"+  cat.getDescription());
	}
		
		context.close();
	}

}
