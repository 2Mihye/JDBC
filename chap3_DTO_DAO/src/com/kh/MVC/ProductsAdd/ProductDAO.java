package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe";
	String password = "khcafe";
	public ProductDAO() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> products = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM products");
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int productID = result.getInt("product_id");
				String productName = result.getString("product_name");
				String category = result.getString("category");
				double price = result.getDouble("price");
				int stockQuantity = result.getInt("stock_quantity");
				
				ProductDTO product = new ProductDTO(productID, productName, category, price, stockQuantity);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	
}
