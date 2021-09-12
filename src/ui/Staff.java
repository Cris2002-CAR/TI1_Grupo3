package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Staff extends Stage{

	private TextField nameTF;

	private TextField idTF;

	private TextField passTF;

	private DatePicker birthdayDT;

	private Button registerBTN;

	private Button signBTN;

	public Staff() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Staff.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			nameTF = (TextField) loader.getNamespace().get("nameTF");
			idTF = (TextField) loader.getNamespace().get("idTF");
			passTF = (TextField) loader.getNamespace().get("passTF");
			birthdayDT = (DatePicker) loader.getNamespace().get("birthdayDT");
			
			registerBTN = (Button) loader.getNamespace().get("registerBTN");
			signBTN = (Button) loader.getNamespace().get("signBTN");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}

	}

}
