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
	
	private Inventory inventory;

	InventoryManager inventoryData;

	public AddIngredient(Inventory inventory) {
		this.inventory = inventory;
		
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
			boolean ingFound = false;

			if (nameInput.getLength() != 0 && unitInput.getLength() != 0 && amountInput.getLength() != 0)
			{
				for(int i = 0 ; i < inventoryData.getInventoryData().size() ; i++)
				{
					if(nameInput.getText().equals(inventoryData.getInventoryData().get(i).getName()))
					{
						ingFound = true;
					}
				}
				
				if(!ingFound)
				{
					String name, unit;
					double amount;

					name = nameInput.getText();
					unit = unitInput.getText();
					amount = Double.parseDouble(amountInput.getText());
					
					inventoryData.addIngredient(name, unit, amount);
					inventory.updateTable();
				}
				else
				{
					Alert ingFoundAlert = new Alert(AlertType.ERROR);
					
					ingFoundAlert.setTitle("Error Dialog");
					ingFoundAlert.setHeaderText("Error de datos:");
					ingFoundAlert.setContentText("Parece que ya hay un ingrediente con ese nombre, intentelo de nuevo");

					ingFoundAlert.showAndWait();
				}
				
			}
			else
			{
				Alert alert = new Alert(AlertType.ERROR);
				
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error de ingreso:");
				alert.setContentText("Parece que no se ha ingresado alguno de los campos necesarios");

				alert.showAndWait();
			}
		});
	}
}
