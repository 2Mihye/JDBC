package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;

public class ShoppingMainTeacher {

	public static void main(String[] args) {
	    ShoppingDAO dao = new ShoppingDAO();
	    ShoppingController controller = new ShoppingController(dao);
	    ShoppingView view = new ShoppingView();
	    
	    List<ShoppingDTO> goods = controller.getAllGoods();
	    
	    Scanner sc = new Scanner (System.in);
	    // 쇼핑 카트 인스턴스 생성자리
	    ShoppingCart cart = new ShoppingCart();
	    
	    int choice = sc.nextInt();
	    
	    switch(choice) {
		    case 1:
		    	// 모든 제품 목록 가져오기
			    // List<ShoppingDTO> goods = controller.getAllGoods();
			    view.showShoppingCart(goods);
		    case 2:
		    	// 최종 가격 계산 가져오기
			    double totalPrice = controller.calculateTotalPrice(goods); // 총 가격 계산
			    view.showTotalPrice(totalPrice);
		    case 3:
		    	// 제품 추가
		    	System.out.println("장바구니에 추가할 제품의 ID를 입력하세요. : ");
		    	// 제품 ID 입력 받기
		    	int productID = sc.nextInt();
		    	// 향상된 for문과 if문을 활용해서 제품 담기
		    	for(ShoppingDTO p : goods) { // goods에서 하나씩 꺼내 쓰겠다는 것임
		    		if(p.getProductID() == productID) {
		    			// 카트에 추가
		    			cart.addToCart(p);
		    			System.out.println(p.getProductName() + "을(를) 장바구니에 담았습니다.");
		    			break;
		    		}
		    	}
		    case 4:
		    	// 제거
		    	System.out.println("장바구니에서 제거할 제품의 ID를 입력하세요. : ");
		    	int removeProductID = sc.nextInt();
		    	// 향상된 for문을 이용하여 제품의 번호를 제공받고 같으면 제거하기
		    	for(ShoppingDTO r : cart.getCartList()/*장바구니 목록*/) {
		    		if(r.getProductID() == removeProductID) {
		    			cart.removeGoods(r);
		    			break;
		    		}
		    	}
		    case 5:
		    	// 결제
		    	UserPay pay = new UserPay(cart);
		    	boolean payResult = pay.payment();
		    	if(payResult) {
		    		// 카트비우기
		    	}
		    	break;
		    default:
		    	System.out.println("잘못된 선택입니다.");
		    	
	    }

	}

}
