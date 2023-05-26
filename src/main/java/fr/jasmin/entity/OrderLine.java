package fr.jasmin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantity;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "item_discount")
	private double itemDiscount;

	@ManyToOne
	@Column(name = "order_id")
	private Order order;

	@ManyToOne
	@Column(name = "item_id")
	private Item item;

	public OrderLine() {

	}

	public OrderLine(int quantity, Order order, Item item) {

		this.setQuantity(quantity);
		this.order = order;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(double itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", itemDiscount="
				+ itemDiscount + ", order=" + order + ", item=" + item + "]";
	}

}
