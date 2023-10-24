package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	// ArrayList
    private List<ShoppingDTO> cartContents; // ��ٱ��Ͽ� �� �� �ִ� �׸��

    // ����īƮ ������
    public ShoppingCart() { // ó���� ��ٱ��ϰ� ��������Ƿ� �ƹ��͵� ���� �� ����
        cartContents = new ArrayList<>(); // ���߿� �����ϱ� ���ؼ� ��������� ���� ���� ����.
    }
    
    // ��ٱ��� ��� �������� get �޼��� ����
    public List<ShoppingDTO> getCartList(){
    	return cartContents;
    }
    
    // ��ٱ��� ���� ���� �ݾ� �޼���
    public double cartTotalPrice() {
    	double totalPrice = 0;
    	// ���� for���� �̿��Ͽ� �ڰ� �߰�
    	for(ShoppingDTO c :  cartContents) {
    		totalPrice += c.getPrice();    		
    	}
    	return totalPrice = 0;
    	
    }
    
    // ��ٱ��Ͽ� �߰��� �޼��� ����
    public void addToCart(ShoppingDTO shopping/*�Ķ���� �� �߰�*/) { // ��ǰ�� �����ؼ� �߰��� ��
        cartContents.add(shopping);
        System.out.println(shopping.getProductName() + "��(��) ��ٱ��Ͽ� �߰��߽��ϴ�.");
    }


    public double calculateTotalPrice() { // �� �ݾ� ���
        double totalPrice = 0;
        for (ShoppingDTO product : cartContents) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
    // ��ٱ��Ͽ��� ��ǰ�� ������ �޼��� ����
    public void removeGoods(ShoppingDTO shopping) {
    	// ���� cartContents���� ��¥ ��ǰ�� �ִٸ� �����ϰڴ�
    	if(cartContents.remove(shopping)) {
    		System.out.println("��ٱ��Ͽ��� �����߽��ϴ�.");
    	} else {
    		System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
    	}
    }
    
}
    
 /*
    public List<ProductDTO> getCartContents() {// ��ٱ��Ͽ� ���
        return cartContents;
    }

    public void showCartContents() { // ��ٱ��� ��� ����
        System.out.println("��ٱ��� ���:");
        for (ProductDTO product : cartContents) {
            System.out.println("��ǰ��: " + product.getProduct_name() + ", ����: " + product.getPrice());
        }
    }
     
    public void clearCart() { // ��ٱ��� ����
        cartContents.clear();
        System.out.println("��ٱ��ϸ� ������ϴ�.");
    }
}*/
