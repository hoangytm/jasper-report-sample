package com.hoangytm.report.myReport;

import com.hoangytm.report.myReport.bookMonitoring.Report;
import com.hoangytm.report.myReport.efileReport.EfileService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author PhanHoang
 * 12/10/2020
 */
@RestController
public class Controller {
    @Autowired
    private Report report;
    @Autowired
    private EfileService efileService;

    @GetMapping("report")
    public Object makeReport() throws IOException, JRException {
        report.exportReport();
        return "success";
    }

    @GetMapping("efileReport")
    public Object makeEfileReport() throws IOException, JRException {
        efileService.exportReport();
        return "success";
    }

}
