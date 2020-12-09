package com.javatechie.report.service;

import com.javatechie.report.entity.Employee;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author PhanHoang
 * 12/4/2020
 */
public class test {
    public static void main(String[] args) throws IllegalAccessException {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        int date = Calendar.getInstance().get(Calendar.DATE);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        System.out.println(date + month);
        List<Employee> em = new ArrayList<>();
        Employee employee = new Employee("hoang2", "vietnam2");
        employee.setDate(new Date());
        Map<String, Object> parameters = new HashMap<>();
        addNewFomatDateToParam(employee, parameters);
        System.out.println(parameters);
    }

    public static void addNewFomatDateToParam(Object obj, Map<String, Object> parameters) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(obj);
            if (value != null) {
                if (field.getType() == Date.class) {
                    System.out.println(field.getName() + "=" + value);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String newDate = formatter.format(date);
                    parameters.put(field.getName(), newDate);
                }

            }
        }
    }
}
