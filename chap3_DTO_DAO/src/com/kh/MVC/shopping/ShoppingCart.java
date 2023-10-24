package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingDTO> cartContents; // 장바구니에 들어갈 수 있는 항목들

    public ShoppingCart() { // 처음에 장바구니가 비어있으므로 아무것도 없는 것 생성
        cartContents = new ArrayList<>();
    }

    public void addToCart(ShoppingDTO product) { // 제품을 선택해서 추가할 것
        cartContents.add(product);
        System.out.println(product.getProductName() + "을(를) 장바구니에 추가했습니다.");
    }


    public double calculateTotalPrice() { // 총 금액 계산
        double totalPrice = 0;
        for (ShoppingDTO product : cartContents) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
}
    
 /*
    public void removeFromCart(ProductDTO product) { // 장바구니에서 상품 제거
        if (cartContents.remove(product)) {
            System.out.println(product.getProduct_name() + "을(를) 장바구니에서 제거했습니다.");
        } else {
            System.out.println("장바구니에 해당 제품이 없습니다.");
        }
    }

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
