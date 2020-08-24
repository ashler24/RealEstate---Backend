package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "city")
@JsonIgnoreProperties({"flatList","houseList"})
public class City {

	private Integer cityId;
	private String cityName;
	private int pincode;
	private Set<Flats> flatList = new HashSet<>();
	private Set<House> houseList = new HashSet<>();

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String cityName, int pincode) {
		super();
		this.cityName = cityName;
		this.pincode = pincode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "city_name")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@OneToMany(mappedBy = "selectedCity", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Flats> getFlatList() {
		return flatList;
	}

	public void setFlatList(Set<Flats> flatList) {
		this.flatList = flatList;
	}

	// convinience helper methods for flats
	public void addFlats(Flats f) {
		flatList.add(f);
		f.setSelectedCity(this);
	}

	public void removeFlat(Flats f) {
		flatList.remove(f);
		f.setSelectedCity(null);

	}
	
	
	@OneToMany(mappedBy = "selectedCity", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(Set<House> houseList) {
		this.houseList = houseList;
	}
	
	// convinience helper methods for house
	public void addHouse(House h) {
		houseList.add(h);
		h.setSelectedCity(this);
	}
	
	public void removeHouse(House h) {
		houseList.remove(h);
		h.setSelectedCity(null);

	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", pincode=" + pincode + "]";
	}
	

	
}
