package ex2019_0508;

public abstract class Product {
	public String name;
	public String company;
	public int day;
	public int numOfStock;
	public int price;
	public int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int scanNum) {
		this.day = scanNum;
	}
	public int getNumOfStock() {
		return numOfStock;
	}
	public void setNumOfStock(int scanNum) {
		this.numOfStock = scanNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
