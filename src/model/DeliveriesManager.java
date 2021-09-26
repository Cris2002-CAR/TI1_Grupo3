package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeliveriesManager {
	
	private static DeliveriesManager instance;
	
	public static DeliveriesManager getInstance() {
		
		if(instance == null) {
			
			instance = new DeliveriesManager();
			;
		}
		return instance;
	}
	
	ObservableList<Deliveries> deliveries;
	
	private DeliveriesManager() {
		
		deliveries = FXCollections.observableArrayList();
	} 
	
	public ObservableList<Deliveries> getDeliveriesData(){
		
		return deliveries; 
	}
	
	public void addDelivery(String id, String order, String amount, String state, String date) {
		
		Deliveries newDelivery = new Deliveries(id, order, amount, state, date);
		deliveries.add(newDelivery);
	}

}
