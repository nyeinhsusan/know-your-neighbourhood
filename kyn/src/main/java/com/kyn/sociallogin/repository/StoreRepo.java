package com.kyn.sociallogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.kyn.sociallogin.dao.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM store " 
			+ "WHERE store_id LIKE %:keyword% OR "
			+ "store_name LIKE %:keyword% OR "
			+ "store_price LIKE %:keyword% OR "

			+ "store_registration LIKE %:keyword%")
	public List<Store> searchstore(@Param("keyword") String keyword);
}
