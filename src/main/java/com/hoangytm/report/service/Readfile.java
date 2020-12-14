package com.hoangytm.report.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author PhanHoang
 * 12/14/2020
 */
public class Readfile {
    public static void main( String[] args) throws FileNotFoundException {
        File initialFile = new File("src/main/resources/employees.jrxml");
        InputStream targetStream = new FileInputStream(initialFile);
        System.out.println("success");
    }
}
