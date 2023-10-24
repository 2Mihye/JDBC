package com.kh.MVC.shop;

import java.util.List;
import java.util.Scanner;

public class ShoppingMain {

	public static void main(String[] args) {
	    ShoppingDAO dao = new ShoppingDAO();
	    ShoppingController controller = new ShoppingController(dao);
	    ShoppingView view = new ShoppingView();

	    List<ShoppingDTO> goods = controller.getAllGoods();
	   // view.showProductList(products);

	    Scanner scanner = new Scanner(System.in);
	    ShoppingCart cart = new ShoppingCart(); // ��ٱ��� ��ü ����

	    while (true) {

	        System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���. ");
	        System.out.print("����Ϸ��� '0' �Է��մϴ�: ");
	        int productID = scanner.nextInt();

	        if (productID == 0) {
	            break;
	        }

	        for (ShoppingDTO product : goods) {
	            if (product.getProductID() == productID) {
	                cart.addToCart(product); // ��ٱ��Ͽ� ��ǰ �߰�
	               
	                break;
	            }
	        }

	    }

	    double totalPrice = cart.calculateTotalPrice(); // �� ���� ���
	    view.showTotalPrice(totalPrice);

	   
	}

}
