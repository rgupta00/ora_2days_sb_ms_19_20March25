package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;
//json parser: java <---> json

import jakarta.validation.Valid;

//We need to handle the exceptions
//100s of endpoint
@RestController
@CrossOrigin("*")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//data + correct httpstatus code
	//ResponseEntity<T> =container =data + status code
	
	//get all products
	@GetMapping(path="products", produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.ok(productService.getAll());
	}
	
	//get by id
	@GetMapping(path="products/{id}")
	public ResponseEntity<Product> getById(@PathVariable(name="id") int id){
			Product product=productService.getProductById(id);
			return ResponseEntity.status(HttpStatus.OK).body(product);
	
	}
	
	//add new product
	@PostMapping(path="products")
	public ResponseEntity<Product> addProduct(  @RequestBody  @Valid Product product){
		Product productToReturn= productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productToReturn);
		
	}
	
	//update
	@PutMapping(path="products/{id}")
	public ResponseEntity<Product> updateById(@PathVariable(name="id") int id,@RequestBody @Valid Product product){
		Product productToReturn= productService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.OK).body(productToReturn);
	}
	
	
	//delete by id
	@DeleteMapping(path="products/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name="id") int id){
		 productService.deleteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}

//Stupid apprach if not using "AOP aspect oriented programming ccc non fun req"

//@GetMapping(path="products/{id}")
//public ResponseEntity<Object> getById(@PathVariable(name="id") int id){
//	try{
//		Product product=productService.getProductById(id);
//		return ResponseEntity.ok(product);
//	}catch(ProductNotFoundException e) {
//		ErrorInfo errorInfo=new ErrorInfo();
//		errorInfo.setErrorCode(401);
//		errorInfo.setErrorMessage(e.getMessage());
//		errorInfo.setTimeStamp(LocalDateTime.now());
//		errorInfo.setToContact("ravi@oracle.com");
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
//	}
//	
//	
//}







////get all products
//	@GetMapping(path="products")
//	public List<Product> getAll(){
//		return productService.getAll();
//	}
//	
//	//get by id
//	@GetMapping(path="products/{id}")
//	public Product getById(@PathVariable(name="id") int id){
//		return productService.getProductById(id);
//	}
//	
//	//add new product
//	@PostMapping(path="products")
//	public Product addProduct(@RequestBody Product product){
//		return productService.addProduct(product);
//	}
//	
//	//update
//	@PutMapping(path="products/{id}")
//	public Product updateById(@PathVariable(name="id") int id,@RequestBody Product product){
//		return productService.updateProduct(id, product);
//	}
//	
//	
//	//delete by id
//	@DeleteMapping(path="products/{id}")
//	public Product deleteById(@PathVariable(name="id") int id){
//		return productService.deleteProduct(id);
//	}
