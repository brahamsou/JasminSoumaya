package fr.jasmin.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	 @Id
	 @GeneratedValue (strategy = GenerationType .IDENTITY)
	 private int id;
	 @Column(name = "name")
	 private String name;
	 @Column(name = "discount")
	 private double discount;
	 @Column(name = "isDiscountCumulative")
	 private boolean isDiscountCumulative;
	 @Column(name = "photo")
	 private String photo;

	 @OneToMany(mappedBy = "category")
	 private List<Item> ItemTitle;

	public Category(int id, String name, double discount, boolean isDiscountCumulative, String photo,
			List<fr.jasmin.entity.Item> itemTitle) {
	
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.isDiscountCumulative = isDiscountCumulative;
		this.photo = photo;
		ItemTitle = itemTitle;
	}

	public Category(String name, List<Item> itemTitles) {
		this(-1,name,0.0, true, "",itemTitles);
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isDiscountCumulative() {
		return isDiscountCumulative;
	}

	public void setDiscountCumulative(boolean isDiscountCumulative) {
		this.isDiscountCumulative = isDiscountCumulative;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Item> getItemTitle() {
		return ItemTitle;
	}

	public void setItemTitle(List<Item> itemTitle) {
		ItemTitle = itemTitle;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", discount=" + discount + ", isDiscountCumulative="
				+ isDiscountCumulative + ", photo=" + photo + ", ItemTitle=" + ItemTitle + "]";
	}
	
	 
	 
}
