package com.niit.backend.dao;


import java.util.List;

import javax.persistence.Query;
import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Category;



@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO 
{
	
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Category> list() {
		
		@SuppressWarnings( { "unchecked", "deprecation" })
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCategory;
	}

	
	
	
		@Transactional
		public void saveOrUpdate (Category category) {
		 sessionFactory.getCurrentSession().saveOrUpdate(category);
		}
	
	@Transactional
	public void delete(String id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.SetId("id");
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}
@Transactional
public Category get(String id){
	String hql = "from"+" Category"+" where id=" + "'"+id+"'";
	// from category where id ='101'
	
	
	
	//@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	

	@SuppressWarnings("unchecked")
	List<Category> listCategory = (List<Category>)query.getResultList();	
	
	if(listCategory != null && !listCategory.isEmpty()) {
		return  listCategory.get(0);
	}
	
	return null;
	
	
}
}

	/*@Transactional
	public List<Category>List(){
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>)
		sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}*/

	
	
	
	

