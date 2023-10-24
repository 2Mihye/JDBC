package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingController {
	private ShoppingDAO dao;
	public ShoppingController(ShoppingDAO dao) {
		this.dao = dao;
	}
	
	// 총 가격 계산 메서드
	public double calculateTotalPrice(List<ShoppingDTO> goods) {
		double totalPrice = 0;
		for(ShoppingDTO totalP : goods) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	public List<ShoppingDTO> getAllGoods(){
		return dao.getAllGoods();
	}
}
