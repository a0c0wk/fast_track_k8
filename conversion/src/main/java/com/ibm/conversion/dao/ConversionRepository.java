package com.ibm.conversion.dao;

import com.ibm.conversion.entity.ConversionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<ConversionTable, Long> {

     ConversionTable findByCountryCode(String country);
}
