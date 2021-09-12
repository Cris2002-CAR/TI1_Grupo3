package model;

public class Dishes {
	
	private String name;
	private int price;
	private double amount;
	private Ingredients ingredient;
	
	public Dishes() {
		
		
	}

	public Dishes(String name, int price, double amount, Ingredients ingredient) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.ingredient = ingredient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Ingredients getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredients ingredient) {
		this.ingredient = ingredient;
	}
	
	

}
