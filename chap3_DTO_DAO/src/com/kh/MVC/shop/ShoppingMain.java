package com.kh.MVC.shop;

import java.util.List;
import java.util.Scanner;

public class ShoppingMain {

	public static void main(String[] args) {
	    ShoppingDAO dao = new ShoppingDAO();
	    ShoppingController controller = new ShoppingController(dao);
	    ShoppingView view = new ShoppingView();

	    List<ShoppingDTO> goods = controller.getAllGoods();
	   // view.showProductList(products);

	    Scanner scanner = new Scanner(System.in);
	    ShoppingCart cart = new ShoppingCart(); // 장바구니 객체 생성

	    while (true) {

	        System.out.println("장바구니에 추가할 제품의 ID를 입력하세요. ");
	        System.out.print("계산하려면 '0' 입력합니다: ");
	        int productID = scanner.nextInt();

	        if (productID == 0) {
	            break;
	        }

	        for (ShoppingDTO product : goods) {
	            if (product.getProductID() == productID) {
	                cart.addToCart(product); // 장바구니에 제품 추가
	               
	                break;
	            }
	        }

	    }

	    double totalPrice = cart.calculateTotalPrice(); // 총 가격 계산
	    view.showTotalPrice(totalPrice);

	   
	}

}
