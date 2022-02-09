package com.country.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.org.entity.Country;
import com.country.org.service.CountryService;


@RestController
@RequestMapping
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	
	@GetMapping("/getCountries")
	public List<Country> getCountries() {
		return countryService.getCountries();
		
	}
	@GetMapping("/getCountries/{id}")
	public ResponseEntity<Country> getCountrybyId(@PathVariable(value="id")int id){
		try {
		  Country country=   countryService.getCountrybyId(id);
		  return new  ResponseEntity<Country>(country,HttpStatus.OK);
		  
	}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
		}
	@GetMapping("/getCountries/countryName")
	public ResponseEntity<Country> getCountryName(@RequestParam(value="name") String countryName){
		
		try {
			  Country country=   countryService.getCountryName(countryName);
			  return new  ResponseEntity<Country>(country,HttpStatus.OK);
			  
		}
			catch(Exception e){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	@PostMapping("/addCountry")
	 public Country addCountry(@RequestBody Country country) {
		 return countryService.addCountry(country);
	 }
	 
	 @PutMapping("/updateCountry/{id}")
	 public ResponseEntity<Country> updateCountry(@PathVariable(value="id")int id,  @RequestBody Country country) {
		 try {
		  Country existingCountry=countryService.getCountrybyId(id);
		            existingCountry.setCountryName(country.getCountryName());
		            existingCountry.setCountryCapital(country.getCountryCapital());
		             Country countryUpdated=  countryService.updateCountry(existingCountry);
		             return new ResponseEntity<Country>(countryUpdated,HttpStatus.OK);
		        }catch(Exception e) {
		        	return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
	 }
	 
	  @DeleteMapping("/deleteMapping/{id}")
	 public AddResponse deleteCountry(@PathVariable (value= "id")int id) {
		  return countryService.deleteCountry(id);
	 
}
}



