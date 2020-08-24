package com.app.dao;

import java.util.List;

import com.app.pojos.City;
import com.app.pojos.Transaction;

public interface IAdminDao {
	List<com.app.pojos.User> getBuyers();
	List<com.app.pojos.User> getOwner();
	List<Transaction> getTxList();
	
	String houseTx(Transaction t, int buyerId, int ownerId);
	String flatTx(Transaction t, int buyerId, int ownerId);
	
	String addCity(City c);
	List<City> getCities();
	
}
