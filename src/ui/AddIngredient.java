package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.InventoryManager;

public class AddIngredient extends Stage {
	private TextField nameInput, unitInput, amountInput;

	private Button addIngBtn;

	InventoryManager inventoryData;

	public AddIngredient() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddIngredient.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 401, 258);
			setScene(scene);

			nameInput = (TextField) loader.getNamespace().get("nameInput");
			unitInput = (TextField) loader.getNamespace().get("unitInput");
			amountInput = (TextField) loader.getNamespace().get("amountInput");
			addIngBtn = (Button) loader.getNamespace().get("addIngBtn");

			inventoryData = inventoryData.getInstance();

			init();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void init() {
		addIngBtn.setOnAction(event -> {

			if (nameInput != null && unitInput != null && amountInput != null) {
				String name, unit;
				double amount;

				name = nameInput.getText();
				unit = unitInput.getText();
				amount = Double.parseDouble(amountInput.getText());
				
				inventoryData.addIngredient(name, unit, amount);
			}
		});
	}
}
