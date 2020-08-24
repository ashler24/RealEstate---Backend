package com.app.dao;

import java.util.List;

import com.app.pojos.Flats;
import com.app.pojos.House;
import com.app.pojos.User;

public interface IOwnerDao {

	String addFlat(Flats f, int userId);

	List<Flats> getFlats(int uid);

	String deleteFlat(int fid);
	
	String deleteHouse(int hid);

	Flats editFlat(Flats fnew, int flatId);

	House editHouse(House hnew, int houseId);

	String addHouse(House houseObj, int userId);

	List<House> getHouses(int uid);

	String changeHouseStatus(int hid);
	
	String changeFlatStatus(int fid);

}
