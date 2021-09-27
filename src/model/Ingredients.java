package model;

public class Ingredients {

	private String name;
	private String unit;
	private double amount;

	public Ingredients() {

	}

	public Ingredients(String name, String unit, double amount) {

		this.name = name;
		this.unit = unit;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void decreAmount(double dAmount)
	{
		this.amount -= dAmount;
	}
	
	public void increAmount(double dAmount)
	{
		this.amount += dAmount;
	}
	
	public String toString()
	{
		return name + "-" + unit + "-" + amount + ";";
	}
}
