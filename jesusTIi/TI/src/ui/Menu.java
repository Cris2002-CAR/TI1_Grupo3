package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Menu extends Stage {

	private Button listBTN;

	private Button invBTN;

	private Button menuBTN;

	private Button delyBTN;

	private Button closeBTN;

	private TableView<?> listMenuTBV;

	private Button addDishBTN;

	private Button deleteDishBTN;

	public Menu() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			listBTN = (Button) loader.getNamespace().get("listBTN");
			invBTN = (Button) loader.getNamespace().get("invBTN");
			menuBTN = (Button) loader.getNamespace().get("menuBTN");
			delyBTN = (Button) loader.getNamespace().get("delyBTN");
			closeBTN = (Button) loader.getNamespace().get("closeBTN");
			addDishBTN = (Button) loader.getNamespace().get("addDishBTN");
			deleteDishBTN = (Button) loader.getNamespace().get("deleteDishBTN");
			
			listMenuTBV = (TableView) loader.getNamespace().get("listMenuTBV");
			
			init();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void init() {
		
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
		
	}
	
	public void showOrders() {
		
		Orders in = new Orders();
		in.show();
		
	}
}
