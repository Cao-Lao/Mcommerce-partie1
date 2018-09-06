package com.ecommerce.microcommerce.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;


@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Length(min = 3, max = 20)
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Float price;

	@Column(nullable = false)
	private Float boughtAtPrice;

	public Product() {

	}

	public Product(final Long id, final String name, final Float price, final Float boughtAtPrice) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.boughtAtPrice = boughtAtPrice;
	}

	public Long getId() {

		return this.id;
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

	public void setId(final Long id) {

		this.id = id;
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

	@Override
	public String toString() {

		return "Product [id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", boughtAtPrice=" + this.boughtAtPrice + "]";
	}
}
