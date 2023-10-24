package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe";
	String password = "khcafe";
	public ShoppingDAO() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ShoppingDTO> getAllGoods(){
		List<ShoppingDTO> goods = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM products");
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int productID = result.getInt("product_id");
				String productName = result.getString("product_name");
				String category = result.getString("category");
				double price = result.getDouble("price");
				int stockQuantity = result.getInt("stock_quantity");
				
				ShoppingDTO shopping = new ShoppingDTO(productID, productName, category, price, stockQuantity);
				goods.add(shopping);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goods;
	}
}
