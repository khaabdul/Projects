package com.EmployeeArrayList;

public class EmployeeBean {
	private int id;
	private String name;
	private String address;

	public String toString() {
		return "id=" + id + ", name=" + name + ", address=" + address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address.substring(0, 1).toUpperCase() + address.substring(1).toLowerCase();
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
