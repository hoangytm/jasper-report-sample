package com.javatechie.report.entity;

/**
 * @author PhanHoang
 * 11/30/2020
 */

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JasperReportFill {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String sourceFileName =
                "C:/Users/Dell/Desktop/jasper/jasper_review.jrxml";
        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new
                JRBeanCollectionDataSource(dataList);
        Map parameters = new HashMap();
        try {
            JasperFillManager.fillReportToFile(
                    sourceFileName, parameters, beanColDataSource);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
