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

import com.riyaz.bean.ProductBean;
import com.riyaz.service.ProductService;


@RestController
public class ProductResource {

	@Autowired
	ProductService service;
	
	
	@GetMapping("products")
	public List<ProductBean> getAllProducts(){
		return service.gettingProduct();
	}
	
	
	/*
	 * @GET
	 * 
	 * @Path("product/{id}")
	 * 
	 * @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) public
	 * ProductBean getOneProduct(@PathParam("id") int id) { System.out.println(id);
	 * return service.getOneProduct(id); }
	 */
	
	@GetMapping("products/product/{id}")
	public ProductBean getOneProduct(@PathVariable int id) {
		return service.getOneProduct(id);
	}
	

	@PostMapping("products/product")
	public ProductBean addProduct(@RequestBody ProductBean p) {
		
		service.addProduct(p);
		return p;
	}
	

	@PutMapping("products/product")
	public ProductBean updateProduct(@RequestBody ProductBean p) {
		System.out.println("print");
		if(service.getOneProduct(p.getItemID()).getItemID() == 0){
			service.addProduct(p);
		}
		else {
		service.update(p);
		}
		return p;
	}
	

	@DeleteMapping("products/product/{id}")
	public ProductBean deleteProduct(@PathVariable int id) {
		ProductBean p = service.getOneProduct(id);
		
		if(p.getItemID()!=0) {
			service.delete(id);
		}
		
		
		
		return p;
	}
}
