package chap2_MVC;

public class Main {
	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		cafeController controller = new cafeController(model, view);
		
		//view.addcafeName();
		//view.updateMenu();
		//view.updateCafe();
		//view.deleteCafe();
		//view.deleteMenu();
		//view.deleteOrder();
		//view.deleteProdect();
		//view.insertProduct();
		controller.run();
	}

}
