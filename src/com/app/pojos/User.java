package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"flatList","houseList","ownerTxList","buyerTxLists"})
public class User {

	private Integer id;
	private String name, email, password, mobile;
	private Role userRole;
	
	private Set<Flats> flatList = new HashSet<>();
	private Set<House> houseList = new HashSet<>();
	private Set<Transaction> ownerTxList = new HashSet<>();
	private Set<Transaction> buyerTxList = new HashSet<>();

	public User() {
		System.out.println("in def ctor of user");
	}

	

	public User(String name, String email, String password, String mobile, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.userRole = userRole;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	

	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@JsonIgnore
	@OneToMany(mappedBy = "associatedUser", cascade = CascadeType.ALL, orphanRemoval = true)
//	@Fetch(value = FetchMode.SUBSELECT)
	public Set<Flats> getFlatList() {
		return flatList;
	}

	public void setFlatList(Set<Flats> flatList) {
		this.flatList = flatList;
	}

	// CONVINIENCE METHODS FOR FLAT
	public void addFlat(Flats f) {
		flatList.add(f);
		f.setAssociatedUser(this);
	}

	public void removeFlat(Flats f) {
		flatList.remove(f);
		f.setAssociatedUser(null);
	}

	@JsonIgnore
	@OneToMany(mappedBy = "associatedUser", cascade = CascadeType.ALL, orphanRemoval = true)
//	@Fetch(value = FetchMode.SUBSELECT)
	public Set<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(Set<House> houseList) {
		this.houseList = houseList;
	}

	// convinience helper methods for house
	public void addHouse(House h) {
		houseList.add(h);
		h.setAssociatedUser(this);
	}

	public void removeHouse(House h) {
		houseList.remove(h);
		h.setAssociatedUser(null);

	}

	@JsonIgnore
	@OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL, orphanRemoval = true)
//	@Fetch(value = FetchMode.SUBSELECT)
	public Set<Transaction> getOwnerTxList() {
		return ownerTxList;
	}

	public void setOwnerTxList(Set<Transaction> ownerTxList) {
		this.ownerTxList = ownerTxList;
	}
	
	public void addOwnerTx(Transaction tx) {
		ownerTxList.add(tx);
		tx.setOwnerId(this);
		
	}

	@JsonIgnore
	@OneToMany(mappedBy = "buyerId", cascade = CascadeType.ALL, orphanRemoval = true)
//	@Fetch(value = FetchMode.SUBSELECT)
	public Set<Transaction> getBuyerTxList() {
		return buyerTxList;
	}

	public void setBuyerTxList(Set<Transaction> buyerTxList) {
		this.buyerTxList = buyerTxList;
	}
	
	public void addBuyerTx(Transaction tx) {
		buyerTxList.add(tx);
		tx.setBuyerId(this);
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", userRole=" + userRole + "]";
	}

	

}
