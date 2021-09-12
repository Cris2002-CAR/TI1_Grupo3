package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Inventory extends Stage{

	private Button listBTN;

	private Button invBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button closeBTN;

	private TableView<?> inventoryTBV;

	private Button addBTN;

	private Button increBTN;

	public Inventory() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root,600,400);
			setScene(scene);
			
			listBTN = (Button) loader.getNamespace().get("listBTN");
			invBTN = (Button) loader.getNamespace().get("invBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			addBTN = (Button) loader.getNamespace().get("addBTN");
			increBTN = (Button) loader.getNamespace().get("increBTN");
			
			inventoryTBV = (TableView) loader.getNamespace().get("inventoryTBV");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
}
