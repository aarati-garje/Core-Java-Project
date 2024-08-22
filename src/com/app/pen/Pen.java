package com.app.pen;

import java.time.LocalDate;

import validations.PenBrand;
import validations.PenMaterial;

public class Pen {
	private static int idCounter = 0;
	private int pId;
	private PenBrand brand;
	private String color;
	private String inkColor;
	private PenMaterial material;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private double price;
	private double discount;

	public Pen(PenBrand brand, String color, String inkColor, PenMaterial material, int stock,
			LocalDate stockUpdateDate, LocalDate stockListingDate, double price, double discount) {
		super();
		this.pId = ++idCounter;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockUpdateDate = stockUpdateDate;
		this.stockListingDate = stockListingDate;
		this.price = price;
		this.discount = discount;
	}

	

	public PenBrand getBrand() {
		return brand;
	}

	public PenMaterial getMaterial() {
		return material;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getpId() {
		return pId;
	}

	public String getColor() {
		return color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public int getStock() {
		return stock;
	}

	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}

	public LocalDate getStockListingDate() {
		return stockListingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setStock(int stock) {
		this.stock = stock;
		this.stockUpdateDate = LocalDate.now();
	}

	
	public boolean isListedInLastNineMonths() {
		LocalDate nineMonthAgo = LocalDate.now().minusMonths(9);
		return stockListingDate.isAfter(nineMonthAgo);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}



	public boolean isSoldInLastThreeMonths() {
		LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
		return stockUpdateDate.isAfter(threeMonthsAgo);
	}        

	@Override
	public String toString() {
		return "Pen [pId=" + pId + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate="
				+ stockListingDate + ", price=" + price + ", discount=" + discount + "]";
	}

}
