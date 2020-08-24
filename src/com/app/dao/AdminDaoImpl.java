package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.City;
import com.app.pojos.Flats;
import com.app.pojos.House;
import com.app.pojos.Role;
import com.app.pojos.Transaction;
import com.app.pojos.User;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> getBuyers() {
		String jpql = "select u from User u where u.userRole= :role";

		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("role", Role.valueOf("BUYER"))
				.getResultList();
	}

	@Override
	public List<User> getOwner() {
		String jpql = "select u from User u where u.userRole= :role";

		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("role", Role.valueOf("OWNER"))
				.getResultList();
	}

	@Override
	public List<Transaction> getTxList() {
		String jpql = "select t from Transaction t";

		return sf.getCurrentSession().createQuery(jpql, Transaction.class).getResultList();
	}

	@Override
	public String houseTx(Transaction t, int buyerId, int ownerId) {
		User buyer = sf.getCurrentSession().get(User.class, buyerId);

		User owner = sf.getCurrentSession().get(User.class, ownerId);
		
		
		buyer.addBuyerTx(t);
		owner.addOwnerTx(t);

		sf.getCurrentSession().update(owner);
		sf.getCurrentSession().update(buyer);

		return "Transaction Added.";
	}

	@Override
	public String flatTx(Transaction t, int buyerId, int ownerId) {
		User buyer = sf.getCurrentSession().get(User.class, buyerId);

		User owner = sf.getCurrentSession().get(User.class, ownerId);

		buyer.addBuyerTx(t);
		owner.addOwnerTx(t);

		sf.getCurrentSession().update(owner);
		sf.getCurrentSession().update(buyer);

		return "Transaction Added.";
	}

	@Override
	public String addCity(City c) {
		c.setCityName(c.getCityName().toLowerCase());
		sf.getCurrentSession().persist(c);
	
		return "City Added";
	}

	@Override
	public List<City> getCities() {
		String jpql = "select c from City c";
		return sf.getCurrentSession().createQuery(jpql,City.class).getResultList();
	}

}
