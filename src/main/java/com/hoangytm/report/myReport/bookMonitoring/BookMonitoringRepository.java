package com.hoangytm.report.myReport.bookMonitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PhanHoang
 * 12/10/2020
 */
@Repository
public interface BookMonitoringRepository extends JpaRepository<BookMonitoring, Long> {
    @Query("select bm from BookMonitoring bm where bm.docCode like  CONCAT('%', CONCAT(UPPER(:docCode),'%')) ")
    List<BookMonitoring> findAllByDocCode(@Param("docCode") String docCode);

}
