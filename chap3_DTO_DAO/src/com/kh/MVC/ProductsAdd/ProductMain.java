package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		// ��� ��ǰ ����Ʈ ��������]
		List<ProductDTO> products = controller.getAllProduct();
		view.showProductList(products);
		
		// ���� ���� ��� ��������
		
	}

}
