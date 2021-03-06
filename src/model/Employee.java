package model;

import java.io.Serializable;

public class Employee implements Serializable {

	private String name;
	private String id;
	private String birthday;
	private String password;

	public Employee() {

	}

	public Employee(String name, String id, String birthday, String password) {
		
		this.name = name;
		this.id = id;
		this.birthday = birthday;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String mensaje=name+" "+id+" "+birthday;
		return mensaje;
	}
	

}
