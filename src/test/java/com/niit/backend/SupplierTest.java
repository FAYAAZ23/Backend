package com.niit.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.model.Supplier;

public class SupplierTest {
	
	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
	
	SupplierDAO supplierDAO = (SupplierDAO)  context.getBean("supplierDAO");
	Supplier s=(Supplier)	  context.getBean("supplier");
	

	s.SetId("TAB_005");
	s.setName("anusha");
	s.setAddress("madinaguda");
	
	
	supplierDAO.saveOrUpdate(s);
	
	supplierDAO.delete("TAB_5");
	supplierDAO.get("TAB_5");
	List<Supplier>  list =    supplierDAO.list();
	
	for(Supplier sup : list)
	{
		System.out.println(sup.getId()  + ":" +  sup.getName()  + ":"+  sup.getAddress());
	}
		
		context.close();
	}

}
