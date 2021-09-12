package ui;

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

	private Button closeBTN;

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
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			changeStBTN = (Button) loader.getNamespace().get("changeStBTN");
			addDeliveryBTN = (Button) loader.getNamespace().get("addDeliveryBTN");
			
			deliveryListTBV = (TableView) loader.getNamespace().get("deliveryListTBV");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
