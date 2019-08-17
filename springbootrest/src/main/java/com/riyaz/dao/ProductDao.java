package com.riyaz.dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.riyaz.bean.ProductBean;

@Repository
public class ProductDao {

	@PersistenceContext
	EntityManager em;
	
public List<ProductBean> getProduct() {
		
	
	List<ProductBean> productList = null;
	
	try {
		
		
		Query query = em.createQuery("select p from ProductBean p where p.itemCount > 0");
		productList = query.getResultList();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	finally {
		em.close();
	}
	
	return productList;
		
	
		
	}

public ProductBean getOneProduct(int id) {
	
	
	try {
		
		ProductBean p = em.find(ProductBean.class, id);
		if(p!=null) {
			return p;
		}	
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	return new ProductBean();
}

public void addProduct(ProductBean p) {

		
		
		try {
			
			em.persist(p);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}

public void delete(int id) {
	// TODO Auto-generated method stub
	
	try {
		
		Query query = em.createQuery("delete from ProductBean p where p.itemID =?1");
		query.setParameter(1, id);
		query.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
}

public void update(ProductBean p) {
	// TODO Auto-generated method stub
	
	try {
		
		Query query = em.createQuery("update ProductBean p set p.itemName=?2,p.itemPrice=?3, p.itemCount=?4 where p.itemID =?1");
		query.setParameter(1, p.getItemID());
		query.setParameter(2, p.getItemName());
		query.setParameter(3, p.getItemPrice());
		query.setParameter(4, p.getItemCount());
		query.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
	

	
}
