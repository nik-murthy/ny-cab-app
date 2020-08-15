package com.nycab.api.dao;

import com.nycab.api.entities.CabTripDataPK;
import com.nycab.api.entities.CabTripData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CabDataRepository extends CrudRepository<CabTripData, String> {

    @Query("select c from CabTripData c where c.medallion=:medallion")
    //@Param("medallion")
    List<CabTripData> findByMedallion(@Param("medallion") String medallion);
}
