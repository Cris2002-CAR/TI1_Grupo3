package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Ingredients;
import model.InventoryManager;

public class ModifyIngredient extends Stage
{
	private InventoryManager inventoryData = InventoryManager.getInstance();;
	
	private Button decreAmount, increAmount;
	
	private TextField amountInput, ingInput;
	
	public ModifyIngredient()
	{
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
			ingInput = (TextField) loader.getNamespace().get("ingInput");
			
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
			String ingredientName = ingInput.getText();
			double amount = Double.parseDouble(amountInput.getText());
			boolean ingFound = false;
			
			for(int i = 0 ; inventoryData.getInventoryData().size() > i || !ingFound ; i++)
			{
				if(ingredientName.equals(inventoryData.getInventoryData().get(i).getName()))
				{
					ingFound = true;
					inventoryData.decreIngQuantity(i, amount);
				}
			}
		});
		
		increAmount.setOnAction(event->
		{
			String ingredientName = ingInput.getText();
			double amount = Double.parseDouble(amountInput.getText());
			boolean ingFound = false;
			
			for(int i = 0 ; inventoryData.getInventoryData().size() > i || !ingFound ; i++)
			{
				if(ingredientName.equals(inventoryData.getInventoryData().get(i).getName()))
				{
					ingFound = true;
					inventoryData.increIngQuantity(i, amount);
				}
			}
		});
	}
}
