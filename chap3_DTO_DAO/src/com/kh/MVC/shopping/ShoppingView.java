package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingView {
	public void showShoppingCart(List<ShoppingDTO> goods) {
		for(ShoppingDTO g : goods) {
			System.out.println("제품명 : " + g.getProductName());
			System.out.println("가격 : " + g.getPrice());
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}