package com.nycab.db.api.dao;

import com.nycab.db.api.entities.CabTripData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CabDataRepository extends CrudRepository<CabTripData, String> {

    @Query("select c from CabTripData c where c.medallion=:medallion")
    List<CabTripData> findByMedallion(@Param("medallion") String medallion);

    @Query("select c from CabTripData c where c.medallion = :medallion " +
            "and date(pickupDatetime) = :date")
    List<CabTripData> findByMedallionAndDate(@Param("medallion") String medallion,
                                             @Param("date") Date date);
}
