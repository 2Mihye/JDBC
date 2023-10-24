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
	    // ���� īƮ �ν��Ͻ� �����ڸ�
	    ShoppingCart cart = new ShoppingCart();
	    
	    int choice = sc.nextInt();
	    
	    switch(choice) {
		    case 1:
		    	// ��� ��ǰ ��� ��������
			    // List<ShoppingDTO> goods = controller.getAllGoods();
			    view.showShoppingCart(goods);
		    case 2:
		    	// ���� ���� ��� ��������
			    double totalPrice = controller.calculateTotalPrice(goods); // �� ���� ���
			    view.showTotalPrice(totalPrice);
		    case 3:
		    	// ��ǰ �߰�
		    	System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���. : ");
		    	// ��ǰ ID �Է� �ޱ�
		    	int productID = sc.nextInt();
		    	// ���� for���� if���� Ȱ���ؼ� ��ǰ ���
		    	for(ShoppingDTO p : goods) { // goods���� �ϳ��� ���� ���ڴٴ� ����
		    		if(p.getProductID() == productID) {
		    			// īƮ�� �߰�
		    			cart.addToCart(p);
		    			System.out.println(p.getProductName() + "��(��) ��ٱ��Ͽ� ��ҽ��ϴ�.");
		    			break;
		    		}
		    	}
		    case 4:
		    	// ����
		    	System.out.println("��ٱ��Ͽ��� ������ ��ǰ�� ID�� �Է��ϼ���. : ");
		    	int removeProductID = sc.nextInt();
		    	// ���� for���� �̿��Ͽ� ��ǰ�� ��ȣ�� �����ް� ������ �����ϱ�
		    	for(ShoppingDTO r : cart.getCartList()/*��ٱ��� ���*/) {
		    		if(r.getProductID() == removeProductID) {
		    			cart.removeGoods(r);
		    			break;
		    		}
		    	}
		    case 5:
		    	// ����
		    	UserPay pay = new UserPay(cart);
		    	boolean payResult = pay.payment();
		    	if(payResult) {
		    		// īƮ����
		    	}
		    	break;
		    default:
		    	System.out.println("�߸��� �����Դϴ�.");
		    	
	    }

	}

}
