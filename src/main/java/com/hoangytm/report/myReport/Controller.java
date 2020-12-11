package com.hoangytm.report.myReport;

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

    @GetMapping("report")
    public Object makeReport() throws IOException, JRException {
         report.exportReport();
        return "success";
    }
}
