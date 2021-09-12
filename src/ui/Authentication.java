package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Authentication extends Stage {
	
	 private TextField idTF;
	 private TextField passTF;
	 
	 private Button ingBTN;
	 private Button regBTN;
	
	public Authentication() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Authentication.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root,600,400);
			setScene(scene);
			
			idTF = (TextField) loader.getNamespace().get("idTF");
			passTF = (TextField) loader.getNamespace().get("passTF");
			
			ingBTN = (Button) loader.getNamespace().get("ingBTN");
			regBTN = (Button) loader.getNamespace().get("regBTN");
			
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
