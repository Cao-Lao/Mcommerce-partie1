package com.ecommerce.microcommerce.web.beans;


public class ProductBean {

	private String name;
	private Float price;
	private Float boughtAtPrice;
	private Float margin;

	public ProductBean() {

	}

	public ProductBean(final String name, final Float price, final Float boughtAtPrice) {

		this.name = name;
		this.price = price;
		this.boughtAtPrice = boughtAtPrice;
		this.margin = price - boughtAtPrice;
	}

	public String getName() {

		return this.name;
	}


	public Float getPrice() {

		return this.price;
	}


	public Float getBoughtAtPrice() {

		return this.boughtAtPrice;
	}


	public Float getMargin() {

		return this.margin;
	}


	public void setName(final String name) {

		this.name = name;
	}


	public void setPrice(final Float price) {

		this.price = price;
	}


	public void setBoughtAtPrice(final Float boughtAtPrice) {

		this.boughtAtPrice = boughtAtPrice;
	}


	public void setMargin(final Float margin) {

		this.margin = margin;
	}

	@Override
	public String toString() {

		return "ProductBean [name=" + this.name + ", price=" + this.price + ", boughtAtPrice=" + this.boughtAtPrice + ", margin=" + this.margin + "]";
	}

}
