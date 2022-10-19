package com.atguigu.team.domain;

public class NoteBook implements Equipement{
	private String model;//机器型号
	private double price;//价格
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}
	public NoteBook() {
		super();
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
