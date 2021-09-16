package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryManager {
	private static InventoryManager instance;

	public static InventoryManager getInstance() {
		if (instance == null) {
			instance = new InventoryManager();
			;
		}

		return instance;
	}

	// Relationships

	ObservableList<Ingredients> ingredients;

	private InventoryManager() {
		ingredients = FXCollections.observableArrayList();
	}

	public ObservableList<Ingredients> getInventoryData() {
		return ingredients;
	}

	public boolean addIngredient(String name, String unit, double amount) {
		boolean filledAll = true;

		if (name != null && unit != null && amount != 0) {
			Ingredients newIngredient = new Ingredients(name, unit, amount);
			ingredients.add(newIngredient);
		} else
			filledAll = false;
		return filledAll;
	}
}
