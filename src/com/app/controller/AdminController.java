package com.app.controller;

import java.util.List;

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

import com.app.dao.IAdminDao;
import com.app.pojos.City;
import com.app.pojos.Transaction;

@RestController // @Controller + @RespBody
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminDao dao;
	
	@GetMapping("/showbuyers")
	public ResponseEntity<?> getBuyers()
	{
		System.out.println("in show buyers of admin");
		
		
			return new ResponseEntity<List<com.app.pojos.User>>(dao.getBuyers(),HttpStatus.OK);
			
		
	}
	
	@GetMapping("/showowners")
	public ResponseEntity<?> getOwners()
	{
		System.out.println("in show owners of admin");
		
		
			return new ResponseEntity<List<com.app.pojos.User>>(dao.getOwner(),HttpStatus.OK);
			
		
	}
	
	@GetMapping("/showtransactions")
	public ResponseEntity<?> getTx()
	{
		System.out.println("in show tx of admin");
		
		
			return new ResponseEntity<List<Transaction>>(dao.getTxList(),HttpStatus.OK);
			
		
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/house/{buyerId}/{ownerId}")
	public ResponseEntity<?> houseTx(@RequestBody Transaction t, @PathVariable int buyerId, @PathVariable int ownerId)
	{
		System.out.println("in housetx"+t.toString());
		System.out.println(buyerId+"   "+ownerId);
		
		if(t!=null)
		{
			return new ResponseEntity<String>(dao.houseTx(t,buyerId,ownerId),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/flat/{buyerId}/{ownerId}")
	public ResponseEntity<?> flatTx(@RequestBody Transaction t, @PathVariable int buyerId, @PathVariable int ownerId)
	{
		System.out.println("in flatTx"+t.toString());
		System.out.println(buyerId+"   "+ownerId);
		
		if(t!=null)
		{
			return new ResponseEntity<String>(dao.flatTx(t,buyerId,ownerId),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addcity")
	public ResponseEntity<?> addCity(@RequestBody City c)
	{
		System.out.println("in add city of admin"+c.toString());
		if(c!=null)
		{
			return new ResponseEntity<String>(dao.addCity(c),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/showcities")
	public ResponseEntity<?> getCities()
	{
		System.out.println("in get cities of admin");
		return new ResponseEntity<List<City>>(dao.getCities(),HttpStatus.OK);
	}
}
