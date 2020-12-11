package com.hoangytm.report.myReport;

import com.hoangytm.report.myReport.bookMonitoring.BookMonitoringDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PhanHoang
 * 12/10/2020
 */
@Repository
public interface BookMonitoringDetailRepository extends JpaRepository<BookMonitoringDetail, Long> {
   BookMonitoringDetail findBookMonitoringDetailByBookMonitoringId(String bookMonitoringId);
}
