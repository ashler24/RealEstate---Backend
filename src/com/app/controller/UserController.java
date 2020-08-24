package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.Flats;
import com.app.pojos.House;
import com.app.pojos.Transaction;
import com.app.pojos.User;

@RestController // @Controller + @RespBody
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;
	

	@PostConstruct
	public void myInit() {
		System.out.println("in init of " + getClass().getName() + " " + dao);
	}
	



	// req handling method to process login form
	
	@PostMapping("/login")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> processLoginForm(@RequestBody User u)
	{
		User v=(User)dao.validateUser(u.getEmail(), u.getPassword());
		
		if(v!=null)
		{
			return new ResponseEntity<User>(v, HttpStatus.OK);
		}
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@PostMapping("/register")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User u)
	{
		
		
		if(u!=null)
		{
			return new ResponseEntity<User>(dao.registerUser(u),HttpStatus.OK);
		}
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/editprofile/{userId}")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> editProfile(@RequestBody User u, @PathVariable int userId)
	{
		System.out.println("in edit profile");
		System.out.println(u.toString());
		
		
		if(u!=null)
		{
			return new ResponseEntity<User>(dao.editProfile(u, userId),HttpStatus.OK);
		}
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	@GetMapping("/showflats")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> getFlatList( )
	{
		System.out.println("in show flats");
		
		
			return new ResponseEntity<List<Flats>>(dao.showFlats(), HttpStatus.OK);
			
		
	}
	
	@GetMapping("/showhouses")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> getHouseList( )
	{
		System.out.println("in show house");
		
		
			return new ResponseEntity<List<House>>(dao.showHouses(), HttpStatus.OK);
			
		
	}
	
	@GetMapping("/displayflat/{flatId}")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> getFlatById(@PathVariable int flatId )
	{
		System.out.println("in show flats by id");
		
		return new  ResponseEntity<Flats>(dao.getFlatById(flatId),HttpStatus.OK);
			
		
	}
	
	@GetMapping("/displayhouse/{houseId}")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> getHouseById(@PathVariable int houseId )
	{
		System.out.println("in show house by id");
		
		return new  ResponseEntity<House>(dao.getHouseId(houseId),HttpStatus.OK);
			
		
	}
	
	@PostMapping("/housetx")  // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> houseTx(@RequestBody Transaction t)
	{
		System.out.println("in edit profile");
		System.out.println(t.toString());
		
		
	
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/showflatsbycity/{cityName}")
	public ResponseEntity<?> getFlatByCity(@PathVariable String cityName)
	{
    	System.out.println("Inside getFlatByCity method of User Controller");
    	String lowercase = cityName.toLowerCase();
    	cityName = lowercase;
    	return new ResponseEntity<List<Flats>>(dao.getFlatsByCity(cityName) , HttpStatus.OK);
	}

	@GetMapping("/showhousesbycity/{cityName}")
	public ResponseEntity<?> getHouseByCity(@PathVariable String cityName)
	{
    	System.out.println("Inside getHouseByCity method of User Controller");
    	
    	return new ResponseEntity<List<House>>(dao.getHousesByCity(cityName) , HttpStatus.OK);
	}
}
