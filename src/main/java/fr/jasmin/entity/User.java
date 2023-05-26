package fr.jasmin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user")
@XmlRootElement
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	private Integer id;

	@NotEmpty
	@Column(name = "last_name", length = 20, nullable = false)
	private String lastName;

	@NotEmpty
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;

	@NotNull
	@Column(name = "birth_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@NotEmpty
	@Column(name = "profil", length = 20, nullable = false)
	private String profil;

	@NotEmpty
	@Column(name = "email", unique = true, length = 30, nullable = false)
	private String email;

	@NotEmpty
	@Column(name = "password", length = 30, nullable = false)
	@Size(min = 8, max = 30)
	private String password;

	@NotEmpty
	@Column(name = "telephone", length = 13, nullable = false)
	private String telephone;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//	@Transient
	private List<Address> addresses = new ArrayList<>();

	/*
	 * @OneToMany(mappedBy = "user") private List<Order> orders = new ArrayList<>();
	 * 
	 * @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) private
	 * List<PaiementCard> paymentCards = new ArrayList<>();
	 * 
	 * @OneToMany(mappedBy = "user") private List<Comment> comments = new
	 * ArrayList<>();
	 * 
	 * @OneToMany(mappedBy = "user") private List<Basket> baskets = new
	 * ArrayList<>();
	 */
	public User( @NotEmpty String lastName, @NotEmpty String firstName) {
		super();
		
		this.lastName = lastName;
		this.firstName = firstName;
		
	}

	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/*
	 * public List<Order> getOrders() { return orders; }
	 * 
	 * public void setOrders(List<Order> orders) { this.orders = orders; }
	 * 
	 * public List<PaiementCard> getPaymentCards() { return paymentCards; }
	 * 
	 * public void setPaymentCards(List<PaiementCard> paymentCards) {
	 * this.paymentCards = paymentCards; }
	 * 
	 * public List<Comment> getComments() { return comments; }
	 * 
	 * public void setComments(List<Comment> comments) { this.comments = comments; }
	 * 
	 * public List<Basket> getBaskets() { return baskets; }
	 * 
	 * public void setBaskets(List<Basket> baskets) { this.baskets = baskets; }
	 */

	@Override
	public String toString() {
		return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", birthDate=" + birthDate
				+ ", isActive=" + isActive + ", profile=" + profil + ", email=" + email + ", password=" + password
				+ ", telephone=" + telephone + "]";
	}
}
