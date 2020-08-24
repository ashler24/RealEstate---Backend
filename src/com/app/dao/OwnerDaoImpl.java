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

@Repository
@Transactional
public class OwnerDaoImpl implements IOwnerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public String addFlat(Flats f, int userId) {
		String jpql = "select c from City c left join fetch c.flatList "+ "left join fetch c.houseList "+"where c.cityName=:nm";
		City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("nm", f.getCity()).getSingleResult();
		c.addFlats(f);
		sf.getCurrentSession().update(c);
		
		User u = sf.getCurrentSession().get(User.class, userId);
		u.addFlat(f);
		sf.getCurrentSession().update(u);
		
		System.out.println("flat added"+f);
		return "Flat Added Successfully";
	}
	
	

	@Override
	public List<Flats> getFlats(int uid) {
		User u = sf.getCurrentSession().get(User.class, uid);
		String jpql = "select f from Flats f where f.associatedUser= :user";
		
		return sf.getCurrentSession().createQuery(jpql, Flats.class).setParameter("user", u).getResultList();
	}



	@Override
	public String deleteFlat(int fid) {
		
	
		Flats f = sf.getCurrentSession().get(Flats.class, fid);
		User u = f.getAssociatedUser();
		String jpql2 = "select c from City c where c.cityName= :city";
		City c = sf.getCurrentSession().createQuery(jpql2, City.class).setParameter("city", f.getCity()).getSingleResult();
		c.removeFlat(f);
		u.removeFlat(f);
		return "Flat Deleted";
	}







	@Override
	public String addHouse(House houseObj, int userId) {
		  String jpql = "Select c from City c where c.cityName=:cname"; 
		  City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("cname", houseObj.getCity()).getSingleResult();
		  
		  User u = sf.getCurrentSession().get(User.class, userId);
		 
		  c.addHouse(houseObj);
		  u.addHouse(houseObj);
		  
		  sf.getCurrentSession().update(c);
		  sf.getCurrentSession().update(u);
		  
		  System.out.println("Recently added House");
		  return "House is successfully added";
	}



	@Override
	public List<House> getHouses(int uid) {
		User u = sf.getCurrentSession().get(User.class, uid);
		   String jpql = "select h from House h where h.associatedUser= :user";
			
		   return sf.getCurrentSession().createQuery(jpql, House.class).setParameter("user", u).getResultList();
	
	}



	@Override
	public String deleteHouse(int hid) {
		House h = sf.getCurrentSession().get(House.class, hid);
		User u1 = h.getAssociatedUser();
		
		String jpql = "Select c from City c where c.cityName=:cityname";
		City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("cityname", h.getCity()).getSingleResult();
		
		c.removeHouse(h);
		u1.removeHouse(h);
		
		sf.getCurrentSession().update(c);
		sf.getCurrentSession().update(u1);
		
		return "House Deleted Successfully";
	}


	 public Flats editFlat(Flats fnew , int flatId)
     {
     	System.out.println(fnew.toString());
     	Flats fold = sf.getCurrentSession().get(Flats.class, flatId);
     	System.out.println("Old flat : "+fold.toString());
     	
     	User u = sf.getCurrentSession().get(User.class, fold.getAssociatedUser().getId());
     	System.out.println("Associated User"+u.toString());
     	
     	String jpql = "select c from City c where c.cityName= :cname";
     	City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("cname", fold.getCity()).getSingleResult();
     	
     	c.removeFlat(fold);
         u.removeFlat(fold);
         
         fnew.setFlatId(flatId);
         c.addFlats(fnew);
         u.addFlat(fnew);
         
         sf.getCurrentSession().merge(c);
         sf.getCurrentSession().merge(u);
        
         return fnew;   
     }
     public House editHouse(House hnew , int houseId)
     {
     	System.out.println(hnew.toString());
     	House hold = sf.getCurrentSession().get(House.class, houseId);
     	System.out.println("Old house : "+hold.toString());
     	
     	User u = sf.getCurrentSession().get(User.class, hold.getAssociatedUser().getId());
     	System.out.println("Associated User"+u.toString());
     	
     	String jpql = "select c from City c where c.cityName= :cname";
     	City c = sf.getCurrentSession().createQuery(jpql, City.class).setParameter("cname", hold.getCity()).getSingleResult();
     	
     	c.removeHouse(hold);
         u.removeHouse(hold);
         
         hnew.setHouseId(houseId);
         c.addHouse(hnew);;
         u.addHouse(hnew);
         
         sf.getCurrentSession().merge(c);
         sf.getCurrentSession().merge(u);
         
     	System.out.println("New house : "+hnew.toString());

        
         return hnew;
     }



	@Override
	public String changeHouseStatus(int hid) {
		House h = sf.getCurrentSession().get(House.class, hid);
		User u = sf.getCurrentSession().get(User.class, h.getAssociatedUser().getId());
		City c = sf.getCurrentSession().get(City.class, h.getSelectedCity().getCityId());
		
		c.removeHouse(h);
		u.removeHouse(h);
		
		h.setStatus("Not Available");
		
		c.addHouse(h);
		u.addHouse(h);
		
		sf.getCurrentSession().merge(c);
		sf.getCurrentSession().merge(u);
		return "Status Changed";
	}



	@Override
	public String changeFlatStatus(int fid) {
		Flats f = sf.getCurrentSession().get(Flats.class, fid);
		User u = sf.getCurrentSession().get(User.class, f.getAssociatedUser().getId());
		City c = sf.getCurrentSession().get(City.class, f.getSelectedCity().getCityId());
		
		c.removeFlat(f);
		u.removeFlat(f);
		
		f.setStatus("Not Available");
		
		c.addFlats(f);
		u.addFlat(f);
		
		sf.getCurrentSession().merge(c);
		sf.getCurrentSession().merge(u);
		return "Status Changed";
	}

	
	
	

}
