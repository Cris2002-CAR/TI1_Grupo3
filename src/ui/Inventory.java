package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Ingredients;
import model.InventoryManager;

public class Inventory extends Stage {

	private Button listBTN;

	private Button invBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button closeBTN;

	private TableView<Ingredients> inventoryTBV;

	private Button addBtn;

	private Button increBtn;

	private Button removeBtn;

	private Button decreBtn;

	private InventoryManager inventoryData;

	public Inventory() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
			Parent root = loader.load();

			inventoryData = InventoryManager.getInstance();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			listBTN = (Button) loader.getNamespace().get("listBTN");
			invBTN = (Button) loader.getNamespace().get("invBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			addBtn = (Button) loader.getNamespace().get("addBtn");
			increBtn = (Button) loader.getNamespace().get("increBtn");
			removeBtn = (Button) loader.getNamespace().get("removeBtn");
			decreBtn = (Button) loader.getNamespace().get("decreBtn");

			inventoryTBV = (TableView) loader.getNamespace().get("inventoryTBV");

			init();

			TableColumn nameCol = new TableColumn("Name:");
			TableColumn unitCol = new TableColumn("Unit:");
			TableColumn amountCol = new TableColumn("Amount:");

			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
			amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

			inventoryTBV.getColumns().addAll(nameCol, unitCol, amountCol);

			inventoryTBV.setItems(inventoryData.getInventoryData());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void init() {
		addBtn.setOnAction(event -> {
			AddIngredient addWindow = new AddIngredient();
			addWindow.show();
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

		closeBTN.setOnAction(event -> {
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

		delyBTN.setOnAction(event -> {
			showOrders();
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

}
