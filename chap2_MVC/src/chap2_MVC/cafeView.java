package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	// cafeModel�̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	// model �Ű������� ���� �� �ִ� �����ڸ� �������� ��.
	public cafeView(cafeModel model) {
		this.model = model;
	}
	public void addcafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.print("��ȣ�� : ");
		String name = sc.nextLine();
		System.out.print("ī�� �ּ� : ");
		String address = sc.nextLine();
		System.out.println("ī�� ����ó : ");
		String phoneNumber = sc.nextLine();
		System.out.println("ī�� ��ð� : ");
		String operatingHours = sc.nextLine();
		
		// ī�� �𵨿��� insertCafe��� �޼��带 ������ �;���

		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
		model.insertCafe(name, address, phoneNumber, operatingHours);
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");
		System.out.print("������ �޴� ���� : ");
		String description = sc.nextLine();
		System.out.print("������ �޴��� ID : ");
		int menuID = sc.nextInt();
		System.out.print("ī�� ID : ");
		int cafeID = sc.nextInt();
		
		// Model�� �ִ� updateMenu�� �����ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.updateMenu(description, menuID, cafeID);
		System.out.println("�޴� ������ update �Ǿ����ϴ�.");
		
	}
	
	public void updateCafe() { // ����ڰ� ��ð� ������ ȭ�� SCanner �̿��ؼ� �����
		Scanner sc = new Scanner(System.in);
		System.out.println("��ð��� ������Ʈ �ϼ���.");
		System.out.print("ī�� ID : ");
		int cafeID = sc.nextInt();
		sc.nextLine();
		System.out.print("�ٲ� ��ð� : ");
		String operatingHours = sc.nextLine();
		
		model.updateCafe(operatingHours, cafeID);
		System.out.println("��ð��� ������Ʈ �Ǿ����ϴ�.");
		
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϼ���.");
		System.out.print("������ ī���� ID : ");
		int cafeID = sc.nextInt();
		// = int cafeID = Integer.parseInt(sc.nextLine()); <= 01~05�� ���� 0�� �տ� ����� �ϴ� ��� String�� ��ȯ����
		
		model.deleteCafe(cafeID);
		System.out.println(cafeID + "ī�並 �����߽��ϴ�.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϼ���.");
		System.out.print("������ �޴��� ID : ");
		int menuID = sc.nextInt();
		
		model.deleteMenu(menuID);
		System.out.println(menuID + "�� �޴��� �����߽��ϴ�.");
	}
	
	public void deleteOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹ��� �����ϼ���.");
		System.out.print("������ �ֹ� ��ȣ : ");
		int orderID = sc.nextInt();
		
		model.deleteOrder(orderID);
		System.out.println(orderID + "�� �ֹ��� �����߽��ϴ�.");		
	}
	
	public void deleteProdect() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ�� �����ϼ���.");
		System.out.print("������ ��ǰ ��ȣ : ");
		int productID = sc.nextInt();
		
		model.deleteProduct(productID);
		System.out.println(productID + "�� ��ǰ�� �����Ǿ����ϴ�.");
	}

	public void insertProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ ������ �Է��ϼ���");
		System.out.print("��ǰ ��ȣ : ");
		int productID = sc.nextInt();
		System.out.print("��ǰ�� : ");
		String productName = sc.next();
		System.out.print("ī�װ� : ");
		String category = sc.next();
		System.out.print("���� : ");
		double price = sc.nextDouble();
		System.out.print("��� : ");
		int quantity = sc.nextInt();
		sc.close();
		
		model.insertProduct(productID, productName, category, price, quantity);
		System.out.println(productName + "(��)�� ���������� �߰��Ǿ����ϴ�.");
	}
	public void selectCafes() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ȯ���� ī�� ��ȣ�� �Է��ϼ��� : ");
		int cafeID = sc.nextInt();
		
		model.selectCafe(cafeID);
		System.out.println("ī�� ��ȸ�� �Ϸ��Ͽ����ϴ�.");
	}
}
