package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Orders extends Stage {

	private Button list;

	private Button inventory;

	private Button menu;

	private Button delyBTN;

	private Button out;

	private TableView<?> deliveryListTBV;

	private Button changeStBTN;

	private Button addDeliveryBTN;

	public Orders() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Orders.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			list = (Button) loader.getNamespace().get("listBTN");
			inventory = (Button) loader.getNamespace().get("invBTN");
			menu = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			out = (Button) loader.getNamespace().get("closeBTN");
			changeStBTN = (Button) loader.getNamespace().get("changeStBTN");
			addDeliveryBTN = (Button) loader.getNamespace().get("addDeliveryBTN");

			deliveryListTBV = (TableView) loader.getNamespace().get("deliveryListTBV");

			init();


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {


		inventory.setOnAction(event -> {
			showInventory();
		});

		list.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.viewList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		out.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.loadLogin();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		menu.setOnAction(event -> {
			showMenu();
		});

	}


	public void showMenu() {

		Menu in = new Menu();
		in.show();
		
	}

	public void showInventory() {

		Inventory in = new Inventory();
		in.show();
		

	}
}
