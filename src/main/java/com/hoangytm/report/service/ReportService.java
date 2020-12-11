package com.hoangytm.report.service;

import com.hoangytm.report.entity.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    public static void main(String[] args) throws IOException, JRException {
        String path = "C:\\Users\\Dell\\Desktop\\jasper";
        //load file and compile it
//        giay_tiep_nhan_va_tra_ket_qua
//        InputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\jasper\\template.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Dell\\Desktop\\jasper\\test.jrxml");
//        make data source
        List<Employee> employees = new ArrayList<>();
        List<Employee> em = new ArrayList<>();
        em.add(new Employee("hoang2", "vietnam2"));
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee("at his home outside Wilmington, Del., with a two-page rundown on the world. The document was prepared by his own foreign policy and intelligence experts, who several times a week also provide a focused brief on one area of a globe", "vietnam2"));
            employees.add(new Employee("hoang3", "at his home outside Wilmington, Del., with a two-page rundown on the world. The document was prepared by his own foreign policy and intelligence experts, who several times a week also provide a focused brief on one area of a globe"));
            employees.add(new Employee("hoang4", "at his home outside Wilmington, Del., with a two-page rundown on the world. The document was prepared by his own foreign policy and intelligence experts, who several times a week also provide a focused brief on one area of a globe"));
            employees.add(new Employee("at his home outside Wilmington, Del., with a two-page rundown on the world. The document was prepared by his own foreign policy and intelligence experts, who several times a week also provide a focused brief on one area of a globe", "vietnam5"));
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(em);

        Map<String, Object> parameters = new HashMap<>();
        File fi = new File("C:\\Users\\Dell\\Desktop\\jasper\\qr.png");

        byte[] fileContent = Files.readAllBytes(fi.toPath());
        BufferedImage bufferedImage = ImageIO.read(Files.newInputStream(Paths.get("C:\\Users\\Dell\\Desktop\\jasper\\qr.png")));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileContent).getImage());
        parameters.put("employees", new JRBeanCollectionDataSource(employees));
        parameters.put("efileCode", "BÁO CÁO TỔNG HỢP HỒ SƠ ĐÃ HỦY");
        parameters.put("imageIcon", bufferedImage);
        parameters.put("payer", "create by hoang");
        parameters.put("reciever", "create by hoang");
        parameters.put("time", "create by hoang");
        SimplePdfExporterConfiguration simplePdfExporterConfiguration = new SimplePdfExporterConfiguration();
        simplePdfExporterConfiguration.setMetadataAuthor("TheGeekyAsian");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        export the pdf file
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("C:/Users/Dell/Desktop/sample_report.xls"));
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setDetectCellType(true);
        configuration.setCollapseRowSpan(false);
        configuration.setOnePagePerSheet(false);
        configuration.setRemoveEmptySpaceBetweenRows(true);
        exporter.setConfiguration(configuration);
//        export  excel file
        exporter.exportReport();
    }
}
