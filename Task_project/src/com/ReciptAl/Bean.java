package com.ReciptAl;

public class Bean {
	private int serial_number = 0;
	private String name;
	private long mobile;
	private String course;
	private String date_of_joing;
	private long courseFee;
	private long paid_fee;
	private String paymant_mode;
	private long total_fee_paid;
	private long balanceTOpaid;

	public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDate_of_joing() {
		return date_of_joing;
	}

	public void setDate_of_joing(String date_of_joing) {
		this.date_of_joing = date_of_joing;
	}

	public long getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(long courseFee) {
		this.courseFee = courseFee;
	}

	public long getPaid_fee() {
		return paid_fee;
	}

	public void setPaid_fee(long paid_fee) {
		this.paid_fee = paid_fee;
	}

	public String getPaymant_mode() {
		return paymant_mode;
	}

	public void setPaymant_mode(String paymant_mode) {
		this.paymant_mode = paymant_mode;
	}

	public long getTotal_fee_paid() {
		return total_fee_paid;
	}

	public void setTotal_fee_paid(long total_fee_paid) {
		this.total_fee_paid = total_fee_paid;
	}

	public long getBalanceTOpaid() {
		return balanceTOpaid;
	}

	public void setBalanceTOpaid(long balanceTOpaid) {
		this.balanceTOpaid = balanceTOpaid;
	}

}
