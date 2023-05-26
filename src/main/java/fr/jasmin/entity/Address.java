package fr.jasmin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "number", length = 6, nullable = false)
	private String number;
	
	@NotEmpty
	@Column(name = "street", length = 45, nullable = false)
	private String street;

	@NotEmpty
	@Column(name = "city", length = 20, nullable = false)
	private String city;

	@NotEmpty
	@Column(name = "postal_code", length = 5, nullable = false)
	private String postalCode;
	//@Transient
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Address(String number, @NotEmpty String street, @NotEmpty String city,
			@NotEmpty String postalCode) {
		super();
		
		this.number = number;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		
	}

	public Address() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", city=" + city + ", postalCode="
				+ postalCode + "]";
	}

}
		

