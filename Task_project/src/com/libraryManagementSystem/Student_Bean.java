package com.libraryManagementSystem;

import java.sql.Date;

public class Student_Bean {
	private int id;
	private String name;
	private String stream;
	private String number;
	private String nameOfBooks;
	private String dateOfIssue;
	private String dateOfReturn;

	public int getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getNameOfBooks() {
		return nameOfBooks;
	}

	public void setNameOfBooks(String nameOfBooks) {
		this.nameOfBooks = nameOfBooks;
	}

}
