package com.riyaz.dao;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.riyaz.bean.CartBean;
import com.riyaz.bean.ProductBean;

@Repository
public class CartDao {

	@PersistenceContext
	EntityManager em;
	
	


public List<CartBean> carts() {
	// TODO Auto-generated method stub
	
	List<CartBean> cartList = null;
	
	try {
		Query query = em.createQuery("select c from CartBean c");
		cartList = query.getResultList();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	finally {
		em.close();
	}
	
	return cartList;
		
	
	
}


public List<CartBean> getUserCart(String username) {
	
	List<CartBean> cartList = null;
	
	try {
		
		Query query = em.createQuery("select c from CartBean c where c.username=?1");
		query.setParameter(1, username);
		cartList = query.getResultList();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	finally {
		em.close();
	}
	
	return cartList;
}


public void updateCart(CartBean c) {
	// TODO Auto-generated method stub
	EntityManager em = null;
	try {
		
		Query query = em.createQuery("update CartBean c set c.itemName=?3,c.itemPrice=?4, c.itemQuantity=?5, c.itemTotal=?6, c.updateMessage = 'no' where c.username =?1 and c.itemID=?2");
		query.setParameter(1, c.getUsername());
		query.setParameter(2, c.getItemID());
		query.setParameter(3, c.getItemName());
		query.setParameter(4, c.getItemPrice());
		query.setParameter(5, c.getItemQuantity());
		query.setParameter(6, c.getItemTotal());
		query.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}


public void addCart(CartBean c) {
	EntityManager em = null;
	try {
		
		
		em.persist(c);
	}
	catch(Exception e) {
		System.out.println(e);
	}
}


public CartBean getUserCartItem(String username, int id) {
	// TODO Auto-generated method stub
	EntityManager em = null;
	CartBean cart = null;
	
	try {
		
		Query query = em.createQuery("select c from CartBean c where c.username=?1 and c.itemID=?2");
		query.setParameter(1, username);
		query.setParameter(2, id);
		cart = (CartBean) query.getSingleResult();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	finally {
		em.close();
	}
	
	return cart;
}


public void delete(String username, int id) {
	// TODO Auto-generated method stub
	EntityManager em = null;
	try {
		
		System.out.println("print");
		Query query = em.createQuery("delete from CartBean c where c.username =?1 and c.itemID=?2");
		query.setParameter(1, username);
		query.setParameter(2, id);
		query.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
}
}
	



