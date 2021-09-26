package ui;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Deliveries;
import model.DeliveriesManager;

public class Orders extends Stage {

	private Button list;

	private Button inventory;

	private Button menu;

	private Button delyBTN;

	private Button out;

	private TableView<Deliveries> deliveryListTBV;

	private Button changeStBTN;

	private Button addDeliveryBTN;
	
	private DeliveriesManager deliveriesData;

	public Orders() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Orders.fxml"));
			Parent root = loader.load();
			
			deliveriesData = DeliveriesManager.getInstance();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			list = (Button) loader.getNamespace().get("list");
			inventory = (Button) loader.getNamespace().get("inventory");
			menu = (Button) loader.getNamespace().get("menu");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			out = (Button) loader.getNamespace().get("out");
			changeStBTN = (Button) loader.getNamespace().get("changeStBTN");
			addDeliveryBTN = (Button) loader.getNamespace().get("addDeliveryBTN");

			deliveryListTBV = (TableView) loader.getNamespace().get("deliveryListTBV");
			
			///////////////////////////////////////////
			
			TableColumn<Deliveries, String> idCol = new TableColumn<>("ID");
			TableColumn<Deliveries, String>  orderCol = new TableColumn<>("Pedido");
			TableColumn<Deliveries, String>  amountCol = new TableColumn<>("Cantidad");
			TableColumn<Deliveries, String>  stateCol = new TableColumn<>("Estado");
			TableColumn<Deliveries, String>  dateCol = new TableColumn<>("Fecha");
			
			idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
			orderCol.setCellValueFactory(new PropertyValueFactory<>("order"));
			amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
			stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
			dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		
			deliveryListTBV.getColumns().addAll(idCol, orderCol, amountCol, stateCol, dateCol);
			
			deliveryListTBV.setItems(deliveriesData.getDeliveriesData());

			init();


		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void init() {


		inventory.setOnAction(event -> {
			showInventory();
		});

		list.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.viewList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		out.setOnAction(event -> {
			try {
				Staff listt = new Staff();
				listt.loadLogin();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		menu.setOnAction(event -> {
			showMenu();
		});
		
		addDeliveryBTN.setOnAction(event -> {
			
			AddDelivery add = new AddDelivery();
			add.show();
		});

	}


	public void showMenu() {

		Menu in = new Menu();
		in.show();
		
	}

	public void showInventory() {

		Inventory in = new Inventory();
		in.show();
		

	}
}
