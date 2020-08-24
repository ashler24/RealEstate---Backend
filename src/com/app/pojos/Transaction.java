package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "transaction")
public class Transaction {

	private Integer txId;
	private String buyer;
	private int estateId;
	private User ownerId,buyerId; 
	private double paymentAmount;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date billingDate;
	private String estateType,estateName;

	public Transaction() {
		System.out.println("in ctor of transaction");
	}

	

	
	
	




	public Transaction(String buyer, int estateId, double paymentAmount, Date billingDate, String estateType,
			String estateName) {
		super();
		this.buyer = buyer;
		this.estateId = estateId;
		this.paymentAmount = paymentAmount;
		this.billingDate = billingDate;
		this.estateType = estateType;
		this.estateName = estateName;
	}










	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tx_id")
	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	
	



	
	@Column(name = "esate_id")
	public int getEstateId() {
		return estateId;
	}





	public void setEstateId(int estateId) {
		this.estateId = estateId;
	}





	@ManyToOne
	@JoinColumn(name = "owner_id")
	public User getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(User ownerId) {
		this.ownerId = ownerId;
	}

	@ManyToOne
	@JoinColumn(name = "buyer_id")
	public User getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(User buyerId) {
		this.buyerId = buyerId;
	}

	@Column(name = "payment_amount")
	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	

	@Temporal(TemporalType.DATE)
	@Column(name = "billing_date") 
	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	
	
	@Column(name = "estate_type")
	public String getEstateType() {
		return estateType;
	}

	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}




	@Column(name = "estate_name")
	public String getEstateName() {
		return estateName;
	}










	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}










	@Override
	public String toString() {
		return "Transaction [txId=" + txId + ", buyer=" + buyer + ", estateId=" + estateId + ", paymentAmount="
				+ paymentAmount + ", billingDate=" + billingDate + ", estateType=" + estateType + "]";
	}

	
	
	
	
	
	

}

	
	
	
	
	


