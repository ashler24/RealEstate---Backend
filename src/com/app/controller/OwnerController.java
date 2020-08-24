package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IOwnerDao;
import com.app.pojos.Flats;
import com.app.pojos.House;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private IOwnerDao dao;

	@SuppressWarnings("unused")
	@PostMapping("/addflats/{id}") // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addFlats(@RequestBody Flats f, @PathVariable int id) {
		System.out.println("in add flats" + f.toString());

		if (f != null) {
			return new ResponseEntity<String>(dao.addFlat(f, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}
	
	//OWNER ADD HOUSE
	@SuppressWarnings("unused")
	@PostMapping("/addhouse/{id}")
    public ResponseEntity<?> addHouse(@RequestBody House houseObj , @PathVariable int id)
    {
    	System.out.println("Inside adding house method of Owner Controller");
    	System.out.println(houseObj.toString());
    	
    	
    	if (houseObj != null) {
			return new ResponseEntity<String>(dao.addHouse(houseObj, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} 	
     }

	@GetMapping("/showflats/{userId}")
	public ResponseEntity<?> getFlatList(@PathVariable int userId) {
		System.out.println("in show flats of owner");

		return new ResponseEntity<List<Flats>>(dao.getFlats(userId), HttpStatus.OK);

	}
	
	
	//SHOW HOUSES TO OWNER
    @GetMapping("/showhouses/{userId}")
	public ResponseEntity<?> getHouseList(@PathVariable int userId)
	{
		System.out.println("in show houses of owner");
			
			return new ResponseEntity<List<House>>(dao.getHouses(userId),HttpStatus.OK);				
	}
	
	
	
	

	@PostMapping("/editflat/{flatId}")
	public ResponseEntity<?> editFlat(@RequestBody Flats fnew , @PathVariable int flatId )
	{
		System.out.println("in  edit flat of owner");
		
    		return new ResponseEntity<Flats>(dao.editFlat(fnew , flatId) , HttpStatus.OK);	
	}
	
	@PostMapping("/edithouse/{houseId}")
	public ResponseEntity<?> editHouse(@RequestBody House hnew , @PathVariable int houseId )
	{
		System.out.println("in  edit flat of owner");
		
    		return new ResponseEntity<House>(dao.editHouse(hnew, houseId) ,  HttpStatus.OK);	
	}
	
	
	
	

	@DeleteMapping("/flat/{flatId}")
	public ResponseEntity<?> deleteFlat(@PathVariable int flatId) {
		System.out.println("in  delete of owner");

		String s = dao.deleteFlat(flatId);
		if (s != null)
			return new ResponseEntity<>(HttpStatus.OK);
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}
	
    //DELETE FLAT BY OWNER
	@DeleteMapping("/deletehouse/{houseId}")
	public ResponseEntity<?> deleteHouse(@PathVariable int houseId)
	{
		System.out.println("in  delete house of owner ");
				
		String s = dao.deleteFlat(houseId);
		if (s != null)
			return new ResponseEntity<>(HttpStatus.OK);
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	// --------------------------------------------------------------------------------
	
	@GetMapping("/housestatus/{houseId}")
	public ResponseEntity<?> changeHouseStatus(@PathVariable int houseId)
	{
		System.out.println("in changeHouse of owner");
		String s = dao.changeHouseStatus(houseId);
		if(s!=null)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/flatstatus/{flatId}")
	public ResponseEntity<?> changeFlatStatus(@PathVariable int flatId)
	{
		System.out.println("in changeFlatStatus of owner");
		String s = dao.changeFlatStatus(flatId);
		if(s!=null)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
