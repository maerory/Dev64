package net.n1books.dev2.jackson;

import java.io.Serializable;

public class Product implements Serializable{
	private String name;
	private int price;
	private int amount;
	private String comment;
	
	public Product(String name, int price, int amount, String comment) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.comment = comment;
	}
	
	public Product() {}
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
