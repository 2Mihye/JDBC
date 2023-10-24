package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingDTO> cartContents; // ��ٱ��Ͽ� �� �� �ִ� �׸��

    public ShoppingCart() { // ó���� ��ٱ��ϰ� ��������Ƿ� �ƹ��͵� ���� �� ����
        cartContents = new ArrayList<>();
    }

    public void addToCart(ShoppingDTO product) { // ��ǰ�� �����ؼ� �߰��� ��
        cartContents.add(product);
        System.out.println(product.getProductName() + "��(��) ��ٱ��Ͽ� �߰��߽��ϴ�.");
    }


    public double calculateTotalPrice() { // �� �ݾ� ���
        double totalPrice = 0;
        for (ShoppingDTO product : cartContents) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
}
    
 /*
    public void removeFromCart(ProductDTO product) { // ��ٱ��Ͽ��� ��ǰ ����
        if (cartContents.remove(product)) {
            System.out.println(product.getProduct_name() + "��(��) ��ٱ��Ͽ��� �����߽��ϴ�.");
        } else {
            System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
        }
    }

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
