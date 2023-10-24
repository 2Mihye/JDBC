package com.kh.MVC.shop;

import java.util.List;

public class ShoppingView {
	public void showShoppingCart(List<ShoppingDTO> goods) {
		for(ShoppingDTO g : goods) {
			System.out.println("��ǰ�� : " + g.getProductName());
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
}