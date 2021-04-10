package com.encore.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;

@Repository 
public class MyProductDAOImpl implements MyProductDAO{

	@Autowired
	SqlSession sqlSession;  // hasing  하는 관계를 나타내는 것 빈 설정문서는 상관없다_ 단지 객체로만 존재하도록 설정문서에서 만들어놓은 거고 코드로 hasing하는 건 field 와 setter // autowired 
	
	private String NS ="ProductMapper.";
	
	
	@Override
	public int addProduct(MyProduct vo) throws Exception {  // DAO에서 메서드 명은 mapping.xml의 아이디 그대로 써야 편하다
		return sqlSession.insert(NS+"addProduct", vo);  // Namspace.mapper.xml에서의 id 로 써준다
		
	}

	@Override
	public List<MyProduct> findProductByName(String words) throws Exception {
		return sqlSession.selectList(NS+"findProductByName", words);
		
	}

	@Override
	public List<MyProduct> findAllProduct() throws Exception {
		return sqlSession.selectList(NS+"findAllProduct");
	
	}

}
