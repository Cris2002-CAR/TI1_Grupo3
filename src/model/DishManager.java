package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DishManager
{
	private static DishManager instance;
	
	public static DishManager getInstance()
	{
		if(instance == null)
		{
			instance = new DishManager();
		}
		
		return instance;
	}
	
	ObservableList<Dishes> dishes;
	
	private DishManager()
	{
		dishes = FXCollections.observableArrayList();
	}
	
	public ObservableList<Dishes> getMenuData()
	{
		return dishes;
	}
	
	public void addDish(String name, double price, ArrayList<Ingredients> ingredients)
	{
		Dishes newDish = new Dishes(name, price, ingredients);
		dishes.add(newDish);
	}
	
	public void removeDish(int ingIndex)
	{
		dishes.remove(ingIndex);
	}
}
