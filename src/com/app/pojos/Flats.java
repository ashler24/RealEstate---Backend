package com.app.pojos;

import java.util.Date;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "flats")
@JsonIgnoreProperties(value= {"image","selectedCity"})
public class Flats {

	private Integer flatId;
	private String apartmentName, flatDescription, petsAllowed, status, ownerName,flatNumber,city,state,address;
	private byte[] image;
	private City selectedCity;
	private double floorSpace, price;
	private int numberOfBalconies, numberOfBedrooms, numberOfBathrooms;
	private User associatedUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date listDate;
	
	private Estate estateType;

	public Flats() {
		System.out.println("in ctor of flats");
	}




	public Flats(String apartmentName, String flatDescription, String petsAllowed, String status, String ownerName,
			String flatNumber, String city, String state, String address, double floorSpace, double price,
			int numberOfBalconies, int numberOfBedrooms, int numberOfBathrooms, Date listDate, Estate estateType) {
		super();
		this.apartmentName = apartmentName;
		this.flatDescription = flatDescription;
		this.petsAllowed = petsAllowed;
		this.status = status;
		this.ownerName = ownerName;
		this.flatNumber = flatNumber;
		this.city = city;
		this.state = state;
		this.address = address;
		this.floorSpace = floorSpace;
		this.price = price;
		this.numberOfBalconies = numberOfBalconies;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.listDate = listDate;
		this.estateType = estateType;
	}










	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flat_id")
	public Integer getFlatId() {
		return flatId;
	}

	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}

	@Column(name = "apartment_name")
	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	@Column(name = "flat_description")
	public String getFlatDescription() {
		return flatDescription;
	}

	public void setFlatDescription(String flatDescription) {
		this.flatDescription = flatDescription;
	}

	@Column(name = "pets_allowed")
	public String getPetsAllowed() {
		return petsAllowed;
	}

	public void setPetsAllowed(String petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "owner_name")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@ManyToOne
	@JoinColumn(name = "city_id")
	public City getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}

	@Column(name = "floor_space")
	public double getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(double floorSpace) {
		this.floorSpace = floorSpace;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "number_of_balconies")
	public int getNumberOfBalconies() {
		return numberOfBalconies;
	}

	public void setNumberOfBalconies(int numberOfBalconies) {
		this.numberOfBalconies = numberOfBalconies;
	}

	@Column(name = "number_of_bedrooms")
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	@Column(name = "number_of_bathrooms")
	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	

	
	@Lob
	public byte[] getImage() {
		return image;
	}




	public void setImage(byte[] image) {
		this.image = image;
	}



	@Temporal(TemporalType.DATE)
	@Column(name = "listed_date")
	public Date getListDate() {
		return listDate;
	}







	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}







	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getAssociatedUser() {
		return associatedUser;
	}

	public void setAssociatedUser(User associatedUser) {
		this.associatedUser = associatedUser;
	}


	
	@Enumerated(EnumType.STRING)
	@Column(name = "estate_type")
	public Estate getEstateType() {
		return estateType;
	}




	public void setEstateType(Estate estateType) {
		this.estateType = estateType;
	}


	
	@Column(name = "flat_number")
	public String getFlatNumber() {
		return flatNumber;
	}



	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}







	@Override
	public String toString() {
		return "Flats [flatId=" + flatId + ", apartmentName=" + apartmentName + ", flatDescription=" + flatDescription
				+ ", petsAllowed=" + petsAllowed + ", status=" + status + ", ownerName=" + ownerName + ", flatNumber="
				+ flatNumber + ", city=" + city + ", state=" + state + ", address=" + address + ", floorSpace="
				+ floorSpace + ", price=" + price + ", numberOfBalconies=" + numberOfBalconies + ", numberOfBedrooms="
				+ numberOfBedrooms + ", numberOfBathrooms=" + numberOfBathrooms + ", listDate=" + listDate
				+ ", estateType=" + estateType + "]";
	}








	
}
