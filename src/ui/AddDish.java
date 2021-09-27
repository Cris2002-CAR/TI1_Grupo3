package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DishManager;
import model.Ingredients;
import model.InventoryManager;

public class AddDish extends Stage
{
	
	private TextField nameInput, priceInput, amountInput;
	private Button addIng, addDish;
	private TableView<Ingredients> inventoryTBV, dishIngTBV;
	
	private ObservableList<Ingredients> newDishIngs;
	
	private InventoryManager inventoryData;
	private DishManager menuData;
	
	public AddDish()
	{
		inventoryData = inventoryData.getInstance();
		menuData = menuData.getInstance();
		newDishIngs = FXCollections.observableArrayList();
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDish.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 450);
			setScene(scene);
			
			nameInput = (TextField) loader.getNamespace().get("nameInput");
			priceInput = (TextField) loader.getNamespace().get("priceInput");
			amountInput = (TextField) loader.getNamespace().get("amountInput");
			
			addIng = (Button) loader.getNamespace().get("addIng");
			addDish = (Button) loader.getNamespace().get("addDish");
			
			inventoryTBV = (TableView<Ingredients>) loader.getNamespace().get("inventoryTBV");
			
			dishIngTBV = (TableView<Ingredients>) loader.getNamespace().get("dishIngTBV");
			dishIngTBV.setEditable(true);
			
			//Inventory TBV
			
			TableColumn nameCol = new TableColumn("Name:");
			TableColumn unitCol = new TableColumn("Unit:");
			TableColumn amountCol = new TableColumn("Amount:");

			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
			amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
			
			inventoryTBV.getColumns().addAll(nameCol, unitCol, amountCol);
			
			inventoryTBV.setItems(inventoryData.getInventoryData());
			
			// Dish Ingredients TBV
			
			TableColumn nameDCol = new TableColumn("Name:");
			TableColumn unitDCol = new TableColumn("Unit:");
			TableColumn amountDCol = new TableColumn("Amount:");

			nameDCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			unitDCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
			amountDCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
			
			dishIngTBV.getColumns().addAll(nameDCol, unitDCol, amountDCol);
			
			dishIngTBV.setItems(newDishIngs);
			
			init();
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	public void init()
	{
		addDish.setOnAction(event->
		{
			boolean dishFound = false;
			
			if(nameInput.getLength() > 0 && priceInput.getLength() > 0 && newDishIngs.size() > 0)
			{
				String dishName = nameInput.getText();
				double dishPrice = Double.parseDouble(priceInput.getText());
				
				for(int i = 0 ; i < menuData.getMenuData().size() ; i++)
				{
					if(dishName.equals(menuData.getMenuData().get(i).getName()))
					{
						dishFound = true;
					}
				}
				
				if(!dishFound)
				{
					ArrayList<Ingredients> ings = new ArrayList<Ingredients>(newDishIngs);
					
					menuData.addDish(dishName, dishPrice, ings);
					
					Menu me = new Menu();
					me.show();
					
					this.close();
				}
				else
				{
					Alert alert = new Alert(AlertType.ERROR);
					
					alert.setHeaderText("Error Dialog");
					alert.setHeaderText("Error de ingreso");
					alert.setContentText("Parece que ya existe un platillo con ese nombre, intenta con un nombre diferente");
					
					alert.showAndWait();
				}
			}
			else
			{
			Alert alert = new Alert(AlertType.ERROR);
			
			alert.setHeaderText("Error Dialog");
			alert.setHeaderText("Error de ingreso");
			alert.setContentText("Parece que no se ha llenado alguno de los campos necesarios");
			
			alert.showAndWait();
			}
		});
		
		addIng.setOnAction(event->
		{
			Ingredients selectedIng = inventoryTBV.getSelectionModel().getSelectedItem();
			
			if(amountInput.getLength() > 0 && selectedIng != null)
			{
				double amount = Double.parseDouble(amountInput.getText());
				Ingredients newIng = new Ingredients(selectedIng.getName(), selectedIng.getUnit(), amount);
				newDishIngs.add(newIng);
				
				updateTable();
			}
			else
			{
				Alert alert = new Alert(AlertType.ERROR);
				
				alert.setHeaderText("Error Dialog");
				alert.setHeaderText("Error de ingreso");
				alert.setContentText("Parece que no se ha seleccionado ningún ingrediente, asegurate de ingresar cual va a ser la cantidad del ingrediente que tendra el platillo");
				
				alert.showAndWait();
			}
		});
		
	}
	
	public void updateTable()
	{
		TableColumn nameDCol = new TableColumn("Name:");
		TableColumn unitDCol = new TableColumn("Unit:");
		TableColumn amountDCol = new TableColumn("Amount:");

		nameDCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		unitDCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
		amountDCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		inventoryTBV.getColumns().setAll(nameDCol, unitDCol, amountDCol);
		
		dishIngTBV.setItems(newDishIngs);
	}
}
