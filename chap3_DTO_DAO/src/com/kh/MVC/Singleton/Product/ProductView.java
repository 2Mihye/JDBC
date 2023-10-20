package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("�� ��ǰ ������ �Է��ϼ���.");
		
		System.out.println("��ǰ ID : ");
		int productID = sc.nextInt();
		System.out.println("��ǰ �̸� : ");
		String productName = sc.next();
		System.out.println("ī�װ� : ");
		String category = sc.next();
		System.out.println("���� : ");
		double price = sc.nextDouble();
		System.out.println("��� : ");
		int quantity = sc.nextInt();
		*/
		
		System.out.println("������Ʈ �� ��ǰ�� ������ �Է��ϼ���.");
		System.out.println("�����ϰ� ���� ī�װ��� : ");
		String category = sc.next();
		System.out.println("��ǰ ID : ");
		int productID = sc.nextInt();
		
		
		// ��ĳ�ʷ� ���� ��ǰ ������ ���� �߰��ϱ�
		
		ProductDTO newProduct = new ProductDTO(category, productID); // INSERT�� (productID, productName, category, price, quantity)
		ProductModel productModel;
		boolean success = false; // ��ǰ�� ���������� �߰��ߴ��� �ƴ��� Ȯ���ϱ� ���� success.
		
		try {
			productModel = ProductModel.getInstance();
			success = productModel.insertProduct(newProduct); // success�� ��� ������ ��ǰ�� �� ������ Ȯ���ϱ� ���ؼ� ���� ��!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("��ǰ�� ���������� ������Ʈ�Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		
		// ��ĳ�� �ݱ�
		sc.close();
		
	}
}
