package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	// ArrayList
    private List<ShoppingDTO> cartContents; // 장바구니에 들어갈 수 있는 항목들

    // 쇼핑카트 생성자
    public ShoppingCart() { // 처음에 장바구니가 비어있으므로 아무것도 없는 것 생성
        cartContents = new ArrayList<>(); // 나중에 결제하기 위해서 멤버변수로 같이 쓰지 않음.
    }
    
    // 장바구니 목록 전달해줄 get 메서드 생성
    public List<ShoppingDTO> getCartList(){
    	return cartContents;
    }
    
    // 장바구니 최조 결제 금액 메서드
    public double cartTotalPrice() {
    	double totalPrice = 0;
    	// 향상된 for문을 이용하여 자격 추가
    	for(ShoppingDTO c :  cartContents) {
    		totalPrice += c.getPrice();    		
    	}
    	return totalPrice = 0;
    	
    }
    
    // 장바구니에 추가할 메서드 생성
    public void addToCart(ShoppingDTO shopping/*파라미터 값 추가*/) { // 제품을 선택해서 추가할 것
        cartContents.add(shopping);
        System.out.println(shopping.getProductName() + "을(를) 장바구니에 추가했습니다.");
    }


    public double calculateTotalPrice() { // 총 금액 계산
        double totalPrice = 0;
        for (ShoppingDTO product : cartContents) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
    // 장바구니에서 물품을 제거할 메서드 생성
    public void removeGoods(ShoppingDTO shopping) {
    	// 만약 cartContents에서 진짜 제품이 있다면 제거하겠다
    	if(cartContents.remove(shopping)) {
    		System.out.println("장바구니에서 제거했습니다.");
    	} else {
    		System.out.println("장바구니에 해당 제품이 없습니다.");
    	}
    }
    
}
    
 /*
    public List<ProductDTO> getCartContents() {// 장바구니에 담기
        return cartContents;
    }

    public void showCartContents() { // 장바구니 목록 보기
        System.out.println("장바구니 목록:");
        for (ProductDTO product : cartContents) {
            System.out.println("제품명: " + product.getProduct_name() + ", 가격: " + product.getPrice());
        }
    }
     
    public void clearCart() { // 장바구니 비우기
        cartContents.clear();
        System.out.println("장바구니를 비웠습니다.");
    }
}*/
