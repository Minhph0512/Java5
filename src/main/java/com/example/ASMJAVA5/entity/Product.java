package com.example.ASMJAVA5.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String image;
	private String name;
	private BigDecimal price;
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<orderDetail> orderDetail ;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
	}

	public Product(Integer id, String image, String name, BigDecimal price, Integer quantity, Category category, List<com.example.ASMJAVA5.entity.orderDetail> orderDetail) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.orderDetail = orderDetail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<com.example.ASMJAVA5.entity.orderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<com.example.ASMJAVA5.entity.orderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
