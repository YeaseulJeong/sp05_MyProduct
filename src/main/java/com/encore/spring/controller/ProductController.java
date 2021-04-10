package com.encore.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

@Controller    // implements Controller 안해도 된다
public class ProductController {
	
	@Autowired
	private MyProductService myProductSevice;   // 어떤걸 hasing 하는지 코드에서 알려주는 것 
	
//	 // 요청의 이름과 메서드를 연결해준다
//	@RequestMapping(value="myProduct.do", method=RequestMethod.POST)
//	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		/*
//		 * 1. form 의 입력 값 받아서
//		 * 2. vo 생성
//		 * 3. service 의 insert 호출
//		 * 4. 결과 페이지와 message를 modelAndView 에 바인딩
//		 */
//		
//		String name = request.getParameter("name");
//		String maker = request.getParameter("maker");
//		int price = Integer.parseInt(request.getParameter("price"));
//		
//		MyProduct vo = new MyProduct(name, maker, price);
//		
//		myProductSevice.addProduct(vo);
//		
//		
//		return new ModelAndView("insert_result", "info", vo);
	
	
	 // 들어온 요청 마다 각각의 요청과 메서드를 연결해준다
		//@RequestMapping(value="myProduct.do", method=RequestMethod.POST)
		@RequestMapping("myProduct.do")   // 이렇게 짧게 써도 된다 
		public ModelAndView insert(MyProduct pvo) throws Exception {       // form에 입력된 name들의 값과 vo 의 필드의 이름이 같으면 form 의 값들이 vo의 자동 바인딩 된다
			/*
			 * 1. form 의 입력 값 받아서
			 * 2. vo 생성
			 * 3. service 의 insert 호출
			 * 4. 결과 페이지와 message를 modelAndView 에 바인딩
			 */
			
			myProductSevice.addProduct(pvo);
			
			return new ModelAndView("insert_result", "info", pvo);  // beans.xml 에서 InternalResourceViewResolver 로 써놨기때문에 위치와 확장자를 안써도 됨
	}
		
		@RequestMapping(value="mySearch.do", method=RequestMethod.GET)
		public ModelAndView getProducts(String word) throws Exception {      // form에 입력된 name들의 값과 파라미터의 이름이 같으면 form 의 값이 자동 바인딩 된다
			/*
			 * 1. form 의 입력 값 받아서
			 * 2. vo 생성
			 * 3. service 의 findProductByName 호출
			 * 4. 결과 페이지와 message를 modelAndView 에 바인딩
			 */
			
			List<MyProduct> list = myProductSevice.findProductByName(word);
			
			return new ModelAndView("find_result", "list", list);
	}
		
		
		
	
	
}
