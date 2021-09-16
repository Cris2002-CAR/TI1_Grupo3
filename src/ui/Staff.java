package ui;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Employee;
import model.StaffList;

public class Staff extends Stage{
	
	public static StaffList list;
	static ObservableList<Employee> observableList;

	@FXML
	private TextField nameTF;
	@FXML
	private TextField idTF;
	@FXML
	private PasswordField passLogin;
	@FXML
	private BorderPane mainPane;
	 @FXML
	 private TextField idLogin;

	@FXML
	private DatePicker birthdayDT;
	@FXML
	private Button registerBTN;
	@FXML
	private Button signBTN;
	@FXML
	private Button listBTN;
	@FXML
	private Button invBTN;
	@FXML
	private Button menuBTN;
	@FXML
	private Button delyBTN;
	@FXML
	private Button closeBTN;
	@FXML
	 private TextField idTFF;
	@FXML
	 private PasswordField passTFF;
	@FXML
	 private Button ingBTN;
	@FXML
	 private Button regBTN;
	@FXML
	private TableView<Employee> table;

	@FXML
	private Button addEmploy;
	
	@FXML
    private TableColumn<Employee, String> userC;

    @FXML
    private TableColumn<Employee, String> dateC;

    @FXML
    private TableColumn<Employee, String> idC;

	public Staff() {
		
		list = list.getInstance();
	}
	
	public void loadLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Authentication.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);
		
	}
	
   
    public void Enter() throws IOException  {
    	if(!idLogin.getText().equals("") && !passLogin.getText().equals("")) {
			boolean s=list.searchUser(idLogin.getText(), passLogin.getText());
			if(!s) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("StaffList.fxml"));

				loader.setController(this);
				Parent addUser = loader.load();

				mainPane.setCenter(addUser);
				mainPane.getChildren().clear();
				mainPane.setTop(addUser);

				table();
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				  alert.setTitle("ERROR");
				  alert.setHeaderText("Invalid User or Password");
				  alert.setContentText("Your Username or Password is incorrect, please try again ");
					  
				  alert.showAndWait();

			}

		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("ERROR");
			 alert.setHeaderText("You must fill all the fields");
			 alert.setContentText(null);
			 alert.showAndWait();

		}
    }
    
	@FXML
	public void createAccount(ActionEvent event) throws IOException {
		String username=nameTF.getText();
		String id=idTFF.getText();
		LocalDate birthday=birthdayDT.getValue();
		String password=passTFF.getText();

		if(!nameTF.getText().equals("") && !passTFF.getText().equals("") && !idTFF.getText().equals("") && birthdayDT.getValue() != null) {
				Employee obj = new Employee(username,id,birthday.toString(),password);
				System.out.println(obj.getId());
					
				FXMLLoader loader = new FXMLLoader(getClass().getResource("StaffList.fxml"));

				loader.setController(this);
				Parent addUser = loader.load();

				mainPane.setCenter(addUser);
				mainPane.getChildren().clear();
				mainPane.setTop(addUser);
			
				
				list.getInstance().getList().add(obj);
				
				//alet
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Empley register");
				alert.setContentText("The new empley has been registered");
				alert.showAndWait();
				
				table();
		}
		else {
	    	Alert alert1 = new Alert(AlertType.ERROR);
			 alert1.setTitle("ERROR");
			 alert1.setHeaderText("You must fill all the fields");
			 alert1.setContentText(null);
			 alert1.showAndWait();
	    }
	}
	

	
	@FXML
	void Enter1(ActionEvent event) throws IOException {
	

	    }

	    @FXML
	    void showRegister(ActionEvent event) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Staff.fxml"));

			loader.setController(this);
			Parent addUser = loader.load();

			mainPane.setCenter(addUser);
			mainPane.getChildren().clear();
			mainPane.setTop(addUser);

	    }
	    
	
	public void table() {

		observableList = FXCollections.observableArrayList(list.getList());

		table.setItems(observableList);
		
		
		//Enlaces con elementos de la tabla
		userC.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		idC.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
		dateC.setCellValueFactory(new PropertyValueFactory<Employee, String>("birthday"));

	}
	
	public void viewList() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StaffList.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);
	}
	
	public void showInventary() {
		
		Inventory in = new Inventory();
		in.show();
		
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


