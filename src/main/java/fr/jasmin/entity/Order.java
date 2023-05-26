package fr.jasmin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {
	   @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   @JoinColumn(name = "number")
	    private String number;
	   @JoinColumn(name = "creationDate")
	    private Date creationDate;
	   @JoinColumn(name = "deliveryDate")
	    private Date deliveryDate;
	   @JoinColumn(name = "totalDiscount")
	    private double totalDiscount;
	   @JoinColumn(name = "shippingFee")
	    private double shippingFee;
	   @JoinColumn(name = "totalAmount")
	    private double totalAmount;

	    @ManyToOne
	    @JoinColumn(name = "billing_address_id")
	    private Address billingAddress;

	    @ManyToOne
	    @JoinColumn(name = "shipping_address_id")
	    private Address shippingAddress;

	    @OneToOne
	    @JoinColumn(name = "default_payment_card_id")
	    private PaymentCard defaultPaymentCard;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    @OneToMany(mappedBy = "order")
	    private List<OrderLine> orderLines;

		public Order() {
			
		}

		public Order(String number, User user, List<OrderLine> orderLines) {
			super();
			this.number = number;
			this.user = user;
			this.orderLines = orderLines;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public Date getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(Date deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public double getTotalDiscount() {
			return totalDiscount;
		}

		public void setTotalDiscount(double totalDiscount) {
			this.totalDiscount = totalDiscount;
		}

		public double getShippingFee() {
			return shippingFee;
		}

		public void setShippingFee(double shippingFee) {
			this.shippingFee = shippingFee;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public Address getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(Address billingAddress) {
			this.billingAddress = billingAddress;
		}

		public Address getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(Address shippingAddress) {
			this.shippingAddress = shippingAddress;
		}

		public PaymentCard getDefaultPaymentCard() {
			return defaultPaymentCard;
		}

		public void setDefaultPaymentCard(PaymentCard defaultPaymentCard) {
			this.defaultPaymentCard = defaultPaymentCard;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<OrderLine> getOrderLines() {
			return orderLines;
		}

		public void setOrderLines(List<OrderLine> orderLines) {
			this.orderLines = orderLines;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", number=" + number + ", creationDate=" + creationDate + ", deliveryDate="
					+ deliveryDate + ", totalDiscount=" + totalDiscount + ", shippingFee=" + shippingFee
					+ ", totalAmount=" + totalAmount + ", billingAddress=" + billingAddress + ", shippingAddress="
					+ shippingAddress + ", defaultPaymentCard=" + defaultPaymentCard + ", user=" + user
					+ ", orderLines=" + orderLines + "]";
		}
	    
	    
}
