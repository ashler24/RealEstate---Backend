package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "houses")
@JsonIgnoreProperties(value= {"image","selectedCity"})
public class House {

	private Integer houseId;
	private byte[] image;
	private String houseName,houseDescription,petsAllowed,status,ownerName,garden,houseNumber,city,state,address;
	private City selectedCity;
	private double floorSpace,price;
	private int numberOfBalconies,numberOfBedrooms,numberOfBathrooms,numberOfFloors;
	private User associatedUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date listDate;
	private Estate estateType;

	public House() {
		System.out.println("in ctor of house");
	}


	








	public House(String houseName, String houseDescription, String petsAllowed, String status, String ownerName,
			String garden, String houseNumber, String city, String state, String address, double floorSpace,
			double price, int numberOfBalconies, int numberOfBedrooms, int numberOfBathrooms, int numberOfFloors,
			Date listDate, Estate estateType) {
		super();
		this.houseName = houseName;
		this.houseDescription = houseDescription;
		this.petsAllowed = petsAllowed;
		this.status = status;
		this.ownerName = ownerName;
		this.garden = garden;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.address = address;
		this.floorSpace = floorSpace;
		this.price = price;
		this.numberOfBalconies = numberOfBalconies;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.numberOfFloors = numberOfFloors;
		this.listDate = listDate;
		this.estateType = estateType;
	}











	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "house_id")
	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	@Column(name = "house_name")
	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	@Column(name = "house_description")
	public String getHouseDescription() {
		return houseDescription;
	}

	public void setHouseDescription(String houseDescription) {
		this.houseDescription = houseDescription;
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

	

	public String getGarden() {
		return garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
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

	@Column(name = "number_of_floors")
	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estate_type")
	public Estate getEstateType() {
		return estateType;
	}




	public void setEstateType(Estate estateType) {
		this.estateType = estateType;
	}



	








	@Column(name="house_number")
	public String getHouseNumber() {
		return houseNumber;
	}











	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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







	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getAssociatedUser() {
		return associatedUser;
	}

	public void setAssociatedUser(User associatedUser) {
		this.associatedUser = associatedUser;
	}




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











	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", houseName=" + houseName + ", houseDescription=" + houseDescription
				+ ", petsAllowed=" + petsAllowed + ", status=" + status + ", ownerName=" + ownerName + ", garden="
				+ garden + ", houseNumber=" + houseNumber + ", city=" + city + ", state=" + state + ", address="
				+ address + ", floorSpace=" + floorSpace + ", price=" + price + ", numberOfBalconies="
				+ numberOfBalconies + ", numberOfBedrooms=" + numberOfBedrooms + ", numberOfBathrooms="
				+ numberOfBathrooms + ", numberOfFloors=" + numberOfFloors + ", listDate=" + listDate + ", estateType="
				+ estateType + "]";
	}




	

	
	
	
	
}
