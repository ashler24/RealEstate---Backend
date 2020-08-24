package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.City;
import com.app.pojos.Flats;
import com.app.pojos.House;
import com.app.pojos.User;




@Repository // To tell SC , whatever follows is a DAO layer
// apply exception translation mechanism(translates hibernate specific excs
// to spring's un chekced excs --for uniform handling across multiple JPA
// vendors
// (DataAccessException)
@Transactional // to enable auto tx management
public class UserDaoImpl implements IUserDao {
	// dependency SF
	@Autowired // byType , mandatory
	private SessionFactory sf;
	// SC tries to search for any spring bean that has implemented SF i/f
	// o.s.orm.hibernate5.LocalSessionFactoryBean
	// (alrdy confgiured in xml file)

	@Override
		public User validateUser(String email1, String pass1) {
			String jpql = "select u from User u left join fetch u.flatList f "+
						  "left join fetch u.houseList h "+
						  "left join fetch u.ownerTxList o "+
						  "left join fetch u.buyerTxList b "+
						  "where u.email=:em and u.password=:pass";
			return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email1)
					.setParameter("pass", pass1).getSingleResult();
		}





	
	
	

	@Override
	public List<Flats> showFlats() {
		String jpql = "select f from Flats f";
		List<Flats> flatList=sf.getCurrentSession().createQuery(jpql, Flats.class).getResultList();
		return flatList;
	}



	@Override
	public List<House> showHouses() {
		String jpql = "select h from House h";
		List<House> houseList=sf.getCurrentSession().createQuery(jpql, House.class).getResultList();
		return houseList;
	}

	
	
	@Override
	public Flats getFlatById(int fId) {
		Flats f = sf.getCurrentSession().get(Flats.class, fId);
		return f;
	}
	
	


	@Override
	public House getHouseId(int hId) {
		House h = sf.getCurrentSession().get(House.class, hId);
		return h;
	}



	@Override
	public User registerUser(User u) {
		
		sf.getCurrentSession().persist(u);
		return u;
	}







	@Override
	public User editProfile(User u, int id) {
		User u1 = sf.getCurrentSession().get(User.class, id);
		u1.setEmail(u.getEmail());
		u1.setName(u.getName());
		u1.setPassword(u.getPassword());
		u1.setMobile(u.getMobile());
		
		sf.getCurrentSession().update(u1);
		return null;
	}









	 public List<Flats> getFlatsByCity(String city)
	   {
		   System.out.println("Inside getFlatsByCity method of User dao");
		   
		   String jpql = "select c from City c where c.cityName=:cname";
		   City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("cname", city).getSingleResult();
		   System.out.println("Selected city is : "+c.toString());

	       String jpql2 = "select f from Flats f where f.selectedCity=:city";
	       return sf.getCurrentSession().createQuery(jpql2, Flats.class).setParameter("city", c).getResultList();
	   }
		 
	   public List<House> getHousesByCity(String city)
	   {
         System.out.println("Inside getHousesByCity method of User dao");
		   
		   String jpql = "select c from City c where c.cityName=:cname";
		   City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("cname", city).getSingleResult();
		   System.out.println("Selected city is : "+c.toString());

	       String jpql2 = "select h from House h where h.selectedCity=:city";
	       return sf.getCurrentSession().createQuery(jpql2, House.class).setParameter("city", c).getResultList();
	       
	   }






}