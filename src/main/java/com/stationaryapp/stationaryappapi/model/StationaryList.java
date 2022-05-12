package com.stationaryapp.stationaryappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "stationaryapp_List")
public class StationaryList {

	@Override
	public String toString() {
		return "StationaryList [id=" + id + ", items_name=" + itemsname + ", brand_name=" + brandname + ", price="
				+ price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemsname() {
		return itemsname;
	}

	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "items_name", nullable = false, unique = true)
	private String itemsname;

	@Column(name = "items_brandname")
	private String brandname;

	@Column(name = "price")
	private float price;
}
