package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")

public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(Supplier supplier) {
	   sessionFactory.getCurrentSession().saveOrUpdate(supplier);	
	}
	
	@Transactional
	public void delete(String id) {
		Supplier supplier=new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
	}
	
	@Transactional
	public Supplier get(String id){
		String hql="from supplier where id="+"'"+id+"'";
		@SuppressWarnings("deprecation")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Supplier> listSupplier=(List<Supplier>)query.list();
		
		if(listSupplier !=null && !listSupplier.isEmpty()){
			return listSupplier.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier=(List<Supplier>) 
		sessionFactory.getCurrentSession()
		.createCriteria(Supplier.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
		}
		
		
	}

