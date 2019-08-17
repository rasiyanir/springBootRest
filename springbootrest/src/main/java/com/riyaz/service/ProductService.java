package com.riyaz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.riyaz.bean.ProductBean;
import com.riyaz.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public ProductService() {
	}
	

	@Transactional
	public List<ProductBean> gettingProduct() {
		return productDao.getProduct();
	}
	

	@Transactional
	public ProductBean getOneProduct(int id) {
		return productDao.getOneProduct(id);
	}


	@Transactional
	public void addProduct(ProductBean p) {
		// TODO Auto-generated method stub
		productDao.addProduct(p);
	}


	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		productDao.delete(id);
	}


	@Transactional
	public void update(ProductBean p) {
		// TODO Auto-generated method stub
		productDao.update(p);
	}


}
