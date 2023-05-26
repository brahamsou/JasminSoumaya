package fr.jasmin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class PaymentCard {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(name = "owner_last_name")
	 private String ownerLastName;
	 @Column(name = "owner_first_name")
	 private String ownerFirstName;
	
	 private String number;
	 @Column(name = "expiration_date")
	 private String expirationDate;
	 @Column(name = "cryptogram")
	 private String cryptogram;

	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private User user;

	public PaymentCard() {
		
	}

	public PaymentCard(String ownerLastName, String ownerFirstName, String number, String expirationDate, User user) {
		
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.number = number;
		this.expirationDate = expirationDate;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastname) {
		this.ownerLastName = ownerLastname;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCryptogram() {
		return cryptogram;
	}

	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PaymentCard [id=" + id + ", ownerLastName=" + ownerLastName + ", ownerFirstName=" + ownerFirstName
				+ ", number=" + number + ", expirationDate=" + expirationDate + ", cryptogram=" + cryptogram + ", user="
				+ user + "]";
	}
	 
	 
}
