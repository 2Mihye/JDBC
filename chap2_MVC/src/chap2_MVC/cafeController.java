package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	// Model�� View�� ������ ������ ����
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	
	// run
	public void run() {
		boolean isTrue = true;
		Scanner sc = new Scanner(System.in);
		// ������ ��ȣ ��� �޼���� �Է�

		while(isTrue) {
			System.out.println("1. ī�� ���� �߰�");
			System.out.println("2. �޴� ���� �߰�");
			System.out.println("3. ����");
			System.out.println("���ϴ� �۾��� �������ּ���.");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				view.addcafeName();
				break;
			case 2:
				view.updateMenu();
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				isTrue = !isTrue;
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
			}
		}
	}
}
