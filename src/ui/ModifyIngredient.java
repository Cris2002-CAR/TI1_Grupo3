package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Ingredients;
import model.InventoryManager;

public class ModifyIngredient extends Stage
{
	private InventoryManager inventoryData = InventoryManager.getInstance();;
	
	private Button decreAmount, increAmount;
	
	private TextField amountInput;
	
	private Label ingBeingMod;
	
	private Ingredients ingredient;
	
	private Inventory inventory;
	
	public ModifyIngredient(Ingredients ingredient, Inventory inventory)
	{
		this.ingredient = ingredient;
		this.inventory = inventory;
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyIngredients.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 400, 250);
			setScene(scene);
			
			////////////////////////////////////////////////////////////////////////////////
			
			decreAmount = (Button) loader.getNamespace().get("decreAmount");
			increAmount = (Button) loader.getNamespace().get("increAmount");
			amountInput = (TextField) loader.getNamespace().get("amountInput");
			
			ingBeingMod = (Label) loader.getNamespace().get("ingBeingMod");
			ingBeingMod.setText(ingredient.getName());
			
			init();
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void init()
	{
		decreAmount.setOnAction(event->
		{
			double amount = Double.parseDouble(amountInput.getText());
			ingredient.decreAmount(amount);
			
			inventory.updateTable();
			this.close();
		});
		
		increAmount.setOnAction(event->
		{
			double amount = Double.parseDouble(amountInput.getText());
			ingredient.increAmount(amount);
			
			inventory.updateTable();
			this.close();
		});
	}
}
