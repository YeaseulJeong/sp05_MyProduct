package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.MyProduct;

/*
 * mapper.xml의 id가 템플릿 메서드 명이 되도록 작성
 */

public interface MyProductDAO {
	
	int addProduct (MyProduct vo) throws Exception;
	List<MyProduct> findProductByName (String words) throws Exception;
	List<MyProduct> findAllProduct () throws Exception;

}
