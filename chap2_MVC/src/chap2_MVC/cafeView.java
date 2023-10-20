package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	// cafeModel이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	// model 매개변수를 받을 수 있는 생성자를 만들어줘야 함.
	public cafeView(cafeModel model) {
		this.model = model;
	}
	public void addcafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.print("상호명 : ");
		String name = sc.nextLine();
		System.out.print("카페 주소 : ");
		String address = sc.nextLine();
		System.out.println("카페 연락처 : ");
		String phoneNumber = sc.nextLine();
		System.out.println("카페 운영시간 : ");
		String operatingHours = sc.nextLine();
		
		// 카페 모델에서 insertCafe라는 메서드를 가지고 와야함

		System.out.println("카페가 성공적으로 추가되었습니다.");
		model.insertCafe(name, address, phoneNumber, operatingHours);
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요.");
		System.out.print("수정할 메뉴 설명 : ");
		String description = sc.nextLine();
		System.out.print("수정할 메뉴의 ID : ");
		int menuID = sc.nextInt();
		System.out.print("카페 ID : ");
		int cafeID = sc.nextInt();
		
		// Model에 있는 updateMenu를 가져와서 사용자가 작성한 수정 내용 추가하기
		model.updateMenu(description, menuID, cafeID);
		System.out.println("메뉴 설명이 update 되었습니다.");
		
	}
	
	public void updateCafe() { // 사용자가 운영시간 수정할 화면 SCanner 이용해서 만들기
		Scanner sc = new Scanner(System.in);
		System.out.println("운영시간을 업데이트 하세요.");
		System.out.print("카페 ID : ");
		int cafeID = sc.nextInt();
		sc.nextLine();
		System.out.print("바꿀 운영시간 : ");
		String operatingHours = sc.nextLine();
		
		model.updateCafe(operatingHours, cafeID);
		System.out.println("운영시간이 업데이트 되었습니다.");
		
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하세요.");
		System.out.print("삭제의 카페의 ID : ");
		int cafeID = sc.nextInt();
		// = int cafeID = Integer.parseInt(sc.nextLine()); <= 01~05와 같이 0을 앞에 적어야 하는 경우 String로 변환인지
		
		model.deleteCafe(cafeID);
		System.out.println(cafeID + "카페를 삭제했습니다.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제하세요.");
		System.out.print("삭제할 메뉴의 ID : ");
		int menuID = sc.nextInt();
		
		model.deleteMenu(menuID);
		System.out.println(menuID + "번 메뉴를 삭제했습니다.");
	}
	
	public void deleteOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주문을 삭제하세요.");
		System.out.print("삭제할 주문 번호 : ");
		int orderID = sc.nextInt();
		
		model.deleteOrder(orderID);
		System.out.println(orderID + "번 주문을 삭제했습니다.");		
	}
	
	public void deleteProdect() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제품을 삭제하세요.");
		System.out.print("삭제할 제품 번호 : ");
		int productID = sc.nextInt();
		
		model.deleteProduct(productID);
		System.out.println(productID + "번 제품이 삭제되었습니다.");
	}

	public void insertProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제품 정보를 입력하세요");
		System.out.print("제품 번호 : ");
		int productID = sc.nextInt();
		System.out.print("제품명 : ");
		String productName = sc.next();
		System.out.print("카테고리 : ");
		String category = sc.next();
		System.out.print("가격 : ");
		double price = sc.nextDouble();
		System.out.print("재고 : ");
		int quantity = sc.nextInt();
		sc.close();
		
		model.insertProduct(productID, productName, category, price, quantity);
		System.out.println(productName + "(이)가 성공적으로 추가되었습니다.");
	}
	public void selectCafes() {
		Scanner sc = new Scanner(System.in);
		System.out.print("확힌할 카페 번호를 입력하세요 : ");
		int cafeID = sc.nextInt();
		
		model.selectCafe(cafeID);
		System.out.println("카페 조회를 완료하였습니다.");
	}
}
