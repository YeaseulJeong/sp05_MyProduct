package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductService {
	
	void addProduct (MyProduct vo) throws Exception;
	List<MyProduct> findProductByName (String words) throws Exception;
	List<MyProduct> findAllProduct () throws Exception;

}
