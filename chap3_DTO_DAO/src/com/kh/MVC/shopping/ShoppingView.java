package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingView {
	public void showShoppingCart(List<ShoppingDTO> goods) {
		for(ShoppingDTO g : goods) {
			System.out.println("��ǰ�� : " + g.getProductName());
			System.out.println("���� : " + g.getPrice());
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
}