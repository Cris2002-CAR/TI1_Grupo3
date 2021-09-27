package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DishManager
{
	private static DishManager instance;
	private static FileWriter fw;
	private static FileReader fr;
	
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
		try {
			fw = new FileWriter("Doc/MenuReport.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ObservableList<Dishes> getMenuData()
	{
		return dishes;
	}
	
	public FileWriter getFW()
	{
		return fw;
	}
	
	public FileReader getFR()
	{
		return fr;
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
	
	public String dataToExport()
	{
		String data = "";
		
		for(Dishes dish : dishes)
		{
			data += dish.toString() + "\n";
		}
		
		return data;
	}
}
