package com.niit.backend.dao;


import java.util.List;

import javax.persistence.Query;
import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Supplier;



@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO 
{
	
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Supplier> list() {
		
		@SuppressWarnings( { "unchecked", "deprecation" })
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listSupplier;
	}

	
	
	
		@Transactional
		public void saveOrUpdate (Supplier supplier) {
		 sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		}
	
	@Transactional
	public void delete(String id) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.SetId("id");
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
	}
@Transactional
public Supplier get(String id){
	String hql = "from"+" Supplier"+" where id=" + "'"+id+"'";
	// from supplier where id ='101'
	
	
	
	//@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	

	@SuppressWarnings("unchecked")
	List<Supplier> listSupplier = (List<Supplier>)query.getResultList();	
	
	if(listSupplier != null && !listSupplier.isEmpty()) {
		return  listSupplier.get(0);
	}
	
	return null;
	
	
}
}

	/*@Transactional
	public List<Supplier>List(){
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>)
		sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
	}*/

	
	
	
	

