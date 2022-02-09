package com.country.org.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.country.org.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> {

	

}
