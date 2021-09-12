package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class StaffList extends Stage {

	private Button listBTN;

	private Button invBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button closeBTN;

	private TableView<?> listEmployTBV;

	private Button addEmployBTN;

	public StaffList() {

		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StaffList.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			listBTN = (Button) loader.getNamespace().get("listBTN");
			invBTN = (Button) loader.getNamespace().get("invBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			addEmployBTN = (Button) loader.getNamespace().get("addEmployBTN");
			
			listEmployTBV = (TableView) loader.getNamespace().get("listEmployTBV");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
