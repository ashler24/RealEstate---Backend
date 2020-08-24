package com.app.dao;

import java.util.List;

import com.app.pojos.Flats;
import com.app.pojos.House;
import com.app.pojos.User;

public interface IUserDao {
	User validateUser(String email, String pass);
	User editProfile(User u, int id);
	User registerUser(User u);
	
	Flats getFlatById(int fId);
	House getHouseId(int hId);
	
	List<Flats> showFlats();
	List<House> showHouses();
	

	List<Flats> getFlatsByCity(String city);
		 
	List<House> getHousesByCity(String city);
}