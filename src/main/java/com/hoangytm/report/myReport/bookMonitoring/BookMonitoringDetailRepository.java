package com.hoangytm.report.myReport.bookMonitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author PhanHoang
 * 12/10/2020
 */
@Repository
public interface BookMonitoringDetailRepository extends JpaRepository<BookMonitoringDetail, Long> {
    BookMonitoringDetail findBookMonitoringDetailByBookMonitoringId(String bookMonitoringId);
}
