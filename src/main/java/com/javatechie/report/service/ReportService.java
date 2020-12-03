package com.javatechie.report.service;

import com.javatechie.report.entity.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    public static void main(String[] args) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Dell\\Desktop\\jasper";
        //load file and compile it
//        giay_tiep_nhan_va_tra_ket_qua
//        InputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\jasper\\template.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Dell\\Desktop\\jasper\\template.jrxml");
//        make data source
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("hoang2", "vietnam2"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("efileCode", "BÁO CÁO TỔNG HỢP HỒ SƠ ĐÃ HỦY");
        parameters.put("payer", "create by hoang");
        parameters.put("reciever", "create by hoang");
        parameters.put("time", "create by hoang");
        SimplePdfExporterConfiguration simplePdfExporterConfiguration = new SimplePdfExporterConfiguration();
        simplePdfExporterConfiguration.setMetadataAuthor("TheGeekyAsian");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
//        JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
    }
}
