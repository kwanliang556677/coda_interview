package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomerManager {
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH-mm-ss";

	@Autowired
	private Environment environment;

	@Transactional
	public void startFileTransaction() throws Exception {
		String fileName = environment.getProperty("file.csv.url");
		try (Stream<String> lines = Files.lines(Paths.get(fileName)).skip(1)) {
			List<List<String>> csvRow = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			for (List<String> customerInfo : csvRow) {
				try {
					generateCustJson(new Customer(customerInfo));
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void generateCustJson(Customer custInfo) throws Exception {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String fileName = environment.getProperty("file.json.url") + "customer_" + sdf.format(cal.getTime()).replaceAll(" ", "")+"_"+ UUID.randomUUID() + ".json";
		FileWriter fileWriter = null;
		try {
			ObjectMapper Obj = new ObjectMapper(); 
			File file = new File(fileName);
			file.createNewFile();
			fileWriter = new FileWriter(fileName);
			fileWriter.write(Obj.writeValueAsString(custInfo));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			fileWriter.close();
		}
	}

}
