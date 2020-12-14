package com.hoangytm.report.myReport.efileReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PhanHoang
 * 12/11/2020
 */
@Repository
public interface EfileRepository extends JpaRepository<Efile, String> {
    List<Efile> findAll();
}
