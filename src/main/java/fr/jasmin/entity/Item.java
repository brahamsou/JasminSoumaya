package fr.jasmin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	private double price;
	private double discount;
	private int stock;
	private boolean isSellable;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Photo> photos;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Video> videos;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Item(String name, String description, double price) {

		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Item() {
		this("", "", 0.0);

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isSellable() {
		return isSellable;
	}

	public void setSellable(boolean isSellable) {
		this.isSellable = isSellable;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ItemTitle [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", discount=" + discount + ", stock=" + stock + ", isSellable=" + isSellable + "]";
	}

}
