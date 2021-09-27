package ui;

import java.io.BufferedWriter;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DishManager;
import model.Dishes;

public class Menu extends Stage {

	private Button listBTN;

	private Button invBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button closeBTN;

	private TableView<Dishes> listMenuTBV;

	private Button addDishBTN;

	private Button deleteDishBTN, expMenuBtn;
	
	private DishManager menuData;

	public Menu() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			Parent root = loader.load();
			
			menuData = menuData.getInstance();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			listBTN = (Button) loader.getNamespace().get("listBTN");
			invBTN = (Button) loader.getNamespace().get("invBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			addDishBTN = (Button) loader.getNamespace().get("addDishBTN");
			deleteDishBTN = (Button) loader.getNamespace().get("deleteDishBTN");
			expMenuBtn = (Button) loader.getNamespace().get("expMenuBtn");

			listMenuTBV = (TableView) loader.getNamespace().get("listMenuTBV");
			listMenuTBV.setEditable(true);
			
			TableColumn nameCol = new TableColumn("Name:");
			TableColumn priceCol = new TableColumn("Price:");
			TableColumn ingredientsCol = new TableColumn("Ingredients");

			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
			ingredientsCol.setCellValueFactory(new PropertyValueFactory<>("ingNames"));

			listMenuTBV.getColumns().addAll(nameCol, priceCol, ingredientsCol);
			
			listMenuTBV.setItems(menuData.getMenuData());
			
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void init() {
		
		addDishBTN.setOnAction(event->
		{
			showAddDish();
			this.close();
		});
		
		deleteDishBTN.setOnAction(event->
		{
			int selectedDish = listMenuTBV.getSelectionModel().getSelectedIndex();
			menuData.removeDish(selectedDish);
		});
		
		expMenuBtn.setOnAction(event->
		{
			exportMenu();
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

		invBTN.setOnAction(event -> {
			showInventory();
		});

		delyBTN.setOnAction(event -> {
			showOrders();
		});
	}

	public void showInventory() {

		Inventory in = new Inventory();
		in.show();
		
		this.close();
	}

	public void showOrders() {

		Orders in = new Orders();
		in.show();

	}
	
	public void showAddDish()
	{
		AddDish add = new AddDish();
		add.show();
	}
	
	public void exportMenu()
	{
		String report = menuData.dataToExport();
		
		try {
			BufferedWriter bw = new BufferedWriter(menuData.getFW());
			
			bw.write(menuData.dataToExport());
			bw.flush();
			
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
}
