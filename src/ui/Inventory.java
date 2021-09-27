package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Ingredients;
import model.InventoryManager;

public class Inventory extends Stage {

	private Button listBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button closeBTN;

	private TableView<Ingredients> inventoryTBV;

	private Button addBtn;

	private Button removeBtn, modifyIngredientsBtn, updateTable, orderTable, expInvBtn;

	private InventoryManager inventoryData;

	public Inventory() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
			Parent root = loader.load();

			inventoryData = InventoryManager.getInstance();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			listBTN = (Button) loader.getNamespace().get("listBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			addBtn = (Button) loader.getNamespace().get("addBtn");
			removeBtn = (Button) loader.getNamespace().get("removeBtn");
			modifyIngredientsBtn = (Button) loader.getNamespace().get("modifyIngredientsBtn");
			updateTable = (Button) loader.getNamespace().get("updateTable");
			orderTable = (Button) loader.getNamespace().get("orderTable");
			expInvBtn = (Button) loader.getNamespace().get("expInvBtn");

			inventoryTBV = (TableView) loader.getNamespace().get("inventoryTBV");
			inventoryTBV.setEditable(true);

			init();

			TableColumn nameCol = new TableColumn("Name:");
			TableColumn unitCol = new TableColumn("Unit:");
			TableColumn amountCol = new TableColumn("Amount:");

			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
			amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

			inventoryTBV.getColumns().addAll(nameCol, unitCol, amountCol);
			updateTable();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void init() {
		addBtn.setOnAction(event -> {
			AddIngredient addWindow = new AddIngredient(this);
			addWindow.show();
		});

		removeBtn.setOnAction(event ->
		{
			inventoryData.removeIngredient(inventoryTBV.getSelectionModel().getSelectedIndex());
		});

		modifyIngredientsBtn.setOnAction(event -> {
			if(inventoryTBV.getSelectionModel().getSelectedItem() != null)
			{
				Ingredients selectedIng = inventoryTBV.getSelectionModel().getSelectedItem();
				ModifyIngredient modWindow = new ModifyIngredient(selectedIng, this);
				modWindow.show();
			}else
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error de ingreso");
				alert.setContentText("Parece que no se ha seleccionado ningún ingrediente");
				
				alert.showAndWait();
			}
		});
		
		orderTable.setOnAction(event->
		{
			inventoryData.selectionSortIngredients();
		});

		updateTable.setOnAction(event -> {
			updateTable();
		});
		
		expInvBtn.setOnAction(event->
		{
			exportInventory();
		});

		listBTN.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.viewList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.close();
		});

		closeBTN.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.loadLogin();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.close();
		});

		menuBTN.setOnAction(event -> {
			showMenu();
			this.close();
		});

		delyBTN.setOnAction(event -> {
			showOrders();
			this.close();
		});
	}

	public void showMenu() {

		Menu in = new Menu();
		in.show();

	}

	public void showOrders() {

		Orders in = new Orders();
		in.show();

	}
	
	public void updateTable()
	{
		TableColumn nameCol = new TableColumn("Name:");
		TableColumn unitCol = new TableColumn("Unit:");
		TableColumn amountCol = new TableColumn("Amount:");

		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
		amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

		inventoryTBV.getColumns().setAll(nameCol, unitCol, amountCol);

		inventoryTBV.setItems(inventoryData.getInventoryData());
	}
	
	public void exportInventory()
	{
		String report = inventoryData.dataToExport();
		
		try {
			BufferedWriter bw = new BufferedWriter(inventoryData.getFW());
			
			bw.write(inventoryData.dataToExport());
			bw.flush();
			
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
