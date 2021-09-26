package model;

public class Deliveries {
	
	private String id;
	private String order;
	private String amount;
	private String state;
	private String date;
	
	public Deliveries(String id, String order, String amount, String state, String date) {
		super();
		this.id = id;
		this.order = order;
		this.amount = amount;
		this.state = state;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
