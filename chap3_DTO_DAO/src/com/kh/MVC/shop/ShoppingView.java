package com.kh.MVC.shop;

import java.util.List;

public class ShoppingView {
	public void showShoppingCart(List<ShoppingDTO> goods) {
		for(ShoppingDTO g : goods) {
			System.out.println("제품명 : " + g.getProductName());
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}