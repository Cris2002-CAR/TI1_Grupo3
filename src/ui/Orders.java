package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Orders extends Stage {

	private Button listBTN;

	private Button invBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button logOutBTN;

	private TableView<?> deliveryListTBV;

	private Button changeStBTN;

	private Button addDeliveryBTN;

	public Orders() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Orders.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			listBTN = (Button) loader.getNamespace().get("listBTN");
			invBTN = (Button) loader.getNamespace().get("invBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			logOutBTN = (Button) loader.getNamespace().get("logOutBTN");
			changeStBTN = (Button) loader.getNamespace().get("changeStBTN");
			addDeliveryBTN = (Button) loader.getNamespace().get("addDeliveryBTN");

			deliveryListTBV = (TableView) loader.getNamespace().get("deliveryListTBV");
			
			init();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {

		invBTN.setOnAction(event -> {
			showInventory();
		});

		listBTN.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.viewList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		logOutBTN.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.loadLogin();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		menuBTN.setOnAction(event -> {
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
