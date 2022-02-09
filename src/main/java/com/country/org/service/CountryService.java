package com.country.org.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SizeAction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.country.org.controller.AddResponse;
import com.country.org.entity.Country;
import com.country.org.repository.CountryRepository;

 
 @Service
 public class CountryService {
	 
	 
	 @Autowired
	 private CountryRepository countryRepo;
		
	       public List<Country> getCountries() {
	    	   
	    	   return countryRepo.findAll();
	    	   
	    	  
	       }
	    	       public Country getCountrybyId(int id){
	    	    	return   countryRepo.findById(id).get();
	    	    	   
	    	       }
	    	       public Country getCountryName(String countryName){
	    	    	  List<Country> countries= countryRepo.findAll();
	    	    	  
	    	    	  Country country=null;
	    	    	  for(Country con:countries) {
	    	    		  if(con.getCountryName().equalsIgnoreCase(countryName))
	    	    		  country= con;
	    	    	    }
					return country;
	    	       }
	    	    		   
	    	   public Country addCountry(Country country) {
	    		   country.setId(getMaxId());
	    		   countryRepo.save(country);
	    		   return country;
	    	   }
	    	     public  int getMaxId() {
	    	    	return   countryRepo.findAll().size()+1;
	    	     }
	    	     
	    	     public Country updateCountry(Country country) {
	    	    	return countryRepo.save(country);
	    	     }
	    	     
	    	       public AddResponse deleteCountry(int id) {
	    	    	   countryRepo.deleteById(id);
	    	    	   AddResponse res= new AddResponse();
	    	    	               res.setMsg("country deleted");
	    	    	               res.setId(id);
	    	    	               return res;
	    	       }
 }