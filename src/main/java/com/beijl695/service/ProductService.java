package com.beijl695.service;

import java.util.List;

import com.beijl695.entity.PageBean;
import com.beijl695.entity.Product;

public interface ProductService {

	public List<Product> findProductList(Product s_product, PageBean pageBean);
	
	public Long getProductCount(Product s_product);
	
	public Product getProductById(int productId);
	
	public void saveProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public void setProductWithHot(int productId);
	
	public void setProductWithSpecialPrice(int productId);
	
	public boolean existProductWithSmallTypeId(int smallTypeId);
	
}
