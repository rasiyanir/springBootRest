package com.riyaz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.riyaz.bean.CartBean;
import com.riyaz.dao.CartDao;


@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public CartService() {
	
	}
	
	@Transactional
	public List<CartBean> carts() {
		// TODO Auto-generated method stub
		return cartDao.carts();
	}

	@Transactional
	public List<CartBean> getUserCart(String username) {
		// TODO Auto-generated method stub
		return cartDao.getUserCart(username);
	}


	@Transactional
	public void addCart(CartBean c) {
		// TODO Auto-generated method stub
		cartDao.addCart(c);
	}


	@Transactional
	public CartBean getUserCartItem(String username, int id) {
		// TODO Auto-generated method stub
		return cartDao.getUserCartItem(username, id);
	}


	@Transactional
	public void update(CartBean c) {
		// TODO Auto-generated method stub
		cartDao.updateCart(c);
	}


	@Transactional
	public void delete(String username, int id) {
		// TODO Auto-generated method stub
		cartDao.delete(username, id);
	}

	
}
