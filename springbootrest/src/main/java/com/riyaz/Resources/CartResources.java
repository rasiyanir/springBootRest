package com.riyaz.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.riyaz.bean.CartBean;
import com.riyaz.service.CartService;

@RestController
public class CartResources {
	
	@Autowired
	CartService service;
	
	@GetMapping("carts")
	public List<CartBean> getCarts(){
		return service.carts();
	}
	
	
	
	@GetMapping("carts/cart/{username}")
	public List<CartBean> getUserCart(@PathVariable String username){
		return service.getUserCart(username);
	}
	

	@GetMapping("carts/cart/{username}/{id}")
	public CartBean getUserCartItem(@PathVariable String username,@PathVariable int id){
		CartBean cart = service.getUserCartItem(username,id);
		if(cart!= null) {
			return cart;
		}
		return new CartBean();
	}
	
	
	@PostMapping("carts/addcart")
	public CartBean createStudent(@RequestBody CartBean c) {
		
		service.addCart(c);
		return c;
	}
	
	@PutMapping("carts/updateCart")
	public CartBean updateCart(@RequestBody CartBean c) {
		System.out.println("gettingusercartitem");
		if(this.getUserCartItem(c.getUsername(), c.getItemID()).getItemID() == 0){
			service.addCart(c);
		}
		else {
		service.update(c);
		}
		return c;
	}
	

	@DeleteMapping("carts/deletecart/{username}/{id}")
	public CartBean deleteCartItem(@PathVariable String username, @PathVariable int id) {
		CartBean c = this.getUserCartItem(username, id);
		
		if(c.getItemID()!=0) {
			service.delete(username, id);
		}
		
		
		
		return c;
	}
	
}
