package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		// 모든 제품 리스트 가져오기]
		List<ProductDTO> products = controller.getAllProduct();
		view.showProductList(products);
		
		// 최종 가격 계산 가져오기
		
	}

}
