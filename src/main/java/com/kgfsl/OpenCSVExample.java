package com.kgfsl;

import java.io.FileReader;
import java.io.IOException;

import java.util.List;

import com.opencsv.CSVReader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.kgfsl.Employee;
import java.util.stream.Collectors; 



/**
 * OpenCSV CSVReader Example, Read line by line
 * 
 * @author pankaj
 *
 */
public class OpenCSVExample {

	public static void main(String[] args) throws IOException {

		CSVReader reader = new CSVReader(new FileReader("D:/kirudiha/csvfiles/emps.csv"), ',');

		HeaderColumnNameMappingStrategy<Employee> beanStrategy = new HeaderColumnNameMappingStrategy<Employee>();
		beanStrategy.setType(Employee.class);
		
		CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
		List<Employee> emps = csvToBean.parse(beanStrategy, reader);
		
		System.out.println(emps);
			
		
		 System.out.println(emps.stream()
		 .map(employee->employee.getName())
		 .collect(Collectors.toList()));
		// .forEach( employee->System.out.println(employee.getName()));
		reader.close();
		
	}
}