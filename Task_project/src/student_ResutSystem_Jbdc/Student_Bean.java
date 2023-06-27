package student_ResutSystem_Jbdc;

public class Student_Bean {
	private int seatNo;
	private String name;
	private int accountancy;
	private int economics;
	private int english;
	private int mathematics;
	private int ocm;
	private int it;
	private int total;
	private float percentage;
	private String remark;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountancy() {
		return accountancy;
	}

	public void setAccountancy(int accountancy) {
		this.accountancy = accountancy;
	}

	public int getEconomics() {
		return economics;
	}

	public void setEconomics(int economics) {
		this.economics = economics;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMathematics() {
		return mathematics;
	}

	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}

	public int getOcm() {
		return ocm;
	}

	public void setOcm(int ocm) {
		this.ocm = ocm;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

}
