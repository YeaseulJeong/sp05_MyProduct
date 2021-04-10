package com.encore.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.MyProduct;

@Service
public class MyProductServiceImpl implements MyProductService{
	
	@Autowired
	private MyProductDAO myProductDAO;   // new 해서 만들 수 없으니까

	@Override
	public void addProduct(MyProduct vo) throws Exception {
		myProductDAO.addProduct(vo);
		
	}

	@Override
	public List<MyProduct> findProductByName(String words) throws Exception {
		return myProductDAO.findProductByName(words);
	}

	@Override
	public List<MyProduct> findAllProduct() throws Exception {
		return myProductDAO.findAllProduct();
	}

}
