package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	public void displayProducts(List<ProductsDTO> products) {
		for(ProductsDTO p : products) {
			System.out.println("Product ID : " + p.getProductID());
			System.out.println("Product Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Quantity : " + p.getQuantity());
			System.out.println();
		}
	}
}
