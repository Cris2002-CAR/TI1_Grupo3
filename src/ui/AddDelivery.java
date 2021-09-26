package ui;

import java.io.IOException;
import java.util.UUID;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DeliveriesManager;

public class AddDelivery extends Stage {

	private ChoiceBox<String> choiceBOX;

	private TextField amountTF;

	private CheckBox pCB;

	private CheckBox processCB;

	private CheckBox deliveredCB;

	private DatePicker dateDT;

	private Button addBTN;
	
	DeliveriesManager deliveryData;
	
	public AddDelivery() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDelivery.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 401, 258);
			setScene(scene);
			
			choiceBOX = (ChoiceBox) loader.getNamespace().get("choiceBOX");
			amountTF = (TextField) loader.getNamespace().get("amountTF");
			pCB = (CheckBox) loader.getNamespace().get("pCB");
			processCB = (CheckBox) loader.getNamespace().get("processCB");
			deliveredCB = (CheckBox) loader.getNamespace().get("deliveredCB");
			dateDT = (DatePicker) loader.getNamespace().get("dateDT");
			addBTN = (Button) loader.getNamespace().get("addBTN");
			
			deliveryData = deliveryData.getInstance();
			
			init();
				
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

	public void init() {
		
		addBTN.setOnAction(event->{
			
			if((choiceBOX.getValue() != null) && (amountTF.getText() != null) && ((pCB.selectedProperty() != null) 
					|| (processCB.selectedProperty() != null) || (deliveredCB.selectedProperty() != null))
					&& (dateDT.getValue() != null)) {
				
				addDeliveries();
			}
			
			else {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ERROR");
				alert.setHeaderText("No se pudo añadir el pedido");
				alert.setContentText("Debes llenar todos los datos del pedido");
				alert.showAndWait();
			}
			
		});
		
	}
	
	public void addDeliveries() {
		
		String id = UUID.randomUUID().toString();
		
		String amount = amountTF.getText();
		
		String state = "";
		
		String order = choiceBOX.getValue().toString();
		
		if(pCB.selectedProperty().get() == true){
			state = pCB.getText();
		}
		else if(processCB.selectedProperty().get() == true) {
			state = processCB.getText();
		}
		else if(deliveredCB.selectedProperty().get() == true){
			state = deliveredCB.getText();
		}
		
		String date = dateDT.getValue().toString();
		
		deliveryData.addDelivery(id, order, amount, state, date);
		
		this.close();
		
	}

}
