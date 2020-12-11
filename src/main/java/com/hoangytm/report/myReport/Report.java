package com.hoangytm.report.myReport;

import com.hoangytm.report.myReport.bookMonitoring.BookMonitoring;
import com.hoangytm.report.myReport.bookMonitoring.BookMonitoringDetail;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

/**
 * @author PhanHoang
 * 12/10/2020
 */
@Service
public class Report {
    @Autowired
    private BookMonitoringDetailRepository bookMonitoringDetailRepository;
    @Autowired
    private BookMonitoringRepository bookMonitoringRepository;

    public void exportReport() throws JRException, IOException {
        String path = "C:\\Users\\Dell\\Desktop\\jasper";
        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Dell\\Desktop\\jasper\\newTest.jrxml");
//        make data source
        List<BookMonitoringDetail> bookMonitoringDetails = getReportBookMonitor();
        List<BookMonitoring> bookMonitorings = bookMonitoringRepository.findAllByDocCode("BM");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookMonitorings);
        Map<String, Object> parameters = new HashMap<>();
        File fi = new File("C:\\Users\\Dell\\Desktop\\jasper\\qr.png");

        byte[] fileContent = Files.readAllBytes(fi.toPath());
        BufferedImage bufferedImage = ImageIO.read(Files.newInputStream(Paths.get("C:\\Users\\Dell\\Desktop\\jasper\\qr.png")));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileContent).getImage());
        parameters.put("bookMonitoringDetails", new JRBeanCollectionDataSource(bookMonitoringDetails));
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

    public List<BookMonitoringDetail> getReportBookMonitor() {
        List<BookMonitoring> lstBookMonitoring = bookMonitoringRepository.findAllByDocCode("BM");
        List<BookMonitoringDetail> bookMonitoringDetails = new ArrayList<>();
        lstBookMonitoring.forEach(r -> {
            BookMonitoringDetail bookMonitoringDetail = bookMonitoringDetailRepository.findBookMonitoringDetailByBookMonitoringId(r.getId());
            bookMonitoringDetails.add(bookMonitoringDetail);
        });


        return bookMonitoringDetails;
    }

}
