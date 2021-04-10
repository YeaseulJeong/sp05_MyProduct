package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.MyProduct;

public class MyBatisUnitTest {
	
	@Test // AppTest ~~ 의 main 에서 실행 했었는데 이 안에서 단위테스트 진행
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();    // 원래는 SqlSessionFactory, SqlSession 모두 라이브러리지만 단위테스트를 하기위해 만듦
		
//		// 화면에서 받은 값이라고 치고 vo생성
//		MyProduct vo = new MyProduct("디오스 세탁기", "엘지", 12000000);  // 화면에서는 자동증가 값을 못 받으니까
//		System.out.println("DB 들어가기 전  "+ vo.getId());   // 0 출력
//		
//		session.insert("ProductMapper.addProduct", vo);    // 이때서야 비로소 DB에 들어갈 수 있다
//		System.out.println("INSESRT OK");
//		System.out.println("DB 들어간 후  "+ vo.getId());  //1    
		// 자동 증가되는 auto increment 값이 PK 일 때는 다시 이 클래스로 주입을 해주어야 한다 안그러면 백날 0 으로만 출력된다
		// DB에서 증가하는 값이 PK 일 때 그걸 insert 할 때  new MyProduct("디오스 세탁기", "엘지", 12000000); 만 하면 이것에 대한 id는 DB에 자동으로 1이 증가 되어 있지만 VO 에서는 빠져있게 됨
		// 그래서 mapper에서 insert tag 안에 useGeneratedKeys="true" keyProperty="id" 넣어주면 됨
//		
//		session.commit();   // spring 연결 하기 전이기 때문에
		
		System.out.println("==================================================================");
		
		List<MyProduct> list = session.selectList("ProductMapper.findProductByName", "공기");
		for(MyProduct v : list) {
			System.out.println(v);
		}
		
//		List<MyProduct> list2 = session.selectList("ProductMapper.findAllProduct");
//		for(MyProduct v : list2) {
//			System.out.println(v);
//		}
	} 

}
