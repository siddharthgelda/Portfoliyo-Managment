package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.model.Portfoliyo;

@Repository
public interface PortfoliyoRepository extends JpaRepository<Portfoliyo, Long> {
	 /*@Query(value = "SELECT * FROM portfoliyo t WHERE t.id = 'id'",
	            nativeQuery=true
	    )*/
	public Portfoliyo findById(Long id);

    }