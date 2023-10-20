package com.kh.MVC.Singleton.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	private static Connection connection;
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static ProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "khcafe";
	
	//�⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private���� ����
	private ProductModel() {
			
	}
	//ProductModel Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
	//�̱��� ������ �����ϴ� ���
	public static ProductModel getInstance() throws SQLException {
		if(productModel == null) {
			productModel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
			
		}
		return productModel;
	}
	
	public boolean insertProduct(ProductDTO product) {
		//String sql = "INSERT INTO products (product_id, product_name, category, price, stock_quantity)"
		//			+"VALUES (?, ?, ?, ?, ?)";
		
		String sql = "UPDATE products SET category = ? WHERE product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			/*//INSERT
			ps.setInt(1, product.getProduct_id());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStock_quantity());*/
			ps.setString(1, product.getCategory());
			ps.setInt(2, product.getProduct_id());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
