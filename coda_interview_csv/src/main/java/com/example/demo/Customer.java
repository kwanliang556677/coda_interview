package com.example.demo;

import java.util.List;

public class Customer {

	public static final Integer FIRST_NAME_IDX = 0;
	public static final Integer LAST_NAME_IDX = 1;
	public static final Integer COMPANY_NAME_IDX = 2;
	public static final Integer ADDRESS_IDX = 3;
	public static final Integer CITY_IDX = 4;
	public static final Integer COUNTY_IDX = 5;
	public static final Integer STATE_IDX = 6;
	public static final Integer ZIP_IDX = 7;
	public static final Integer PHONE1_IDX = 8;
	public static final Integer PHONE2_IDX = 9;
	public static final Integer EMAIL_IDX = 10;
	public static final Integer WEB_IDX = 11;

	private String firstName;
	private String lastName;
	private String companyName;
	private String address;
	private String city;
	private String county;
	private String state;
	private String zip;
	private String phone1;
	private String phone2;
	private String email;
	private String web;

	public Customer(List<String> customerInfo) {
		this.setFirstName(customerInfo.get(FIRST_NAME_IDX));
		this.setLastName(customerInfo.get(LAST_NAME_IDX));
		this.setCompanyName(customerInfo.get(COMPANY_NAME_IDX));
		this.setAddress(customerInfo.get(ADDRESS_IDX));
		this.setCity(customerInfo.get(FIRST_NAME_IDX));
		this.setCounty(customerInfo.get(COUNTY_IDX));
		this.setState(customerInfo.get(STATE_IDX));
		this.setZip(customerInfo.get(ZIP_IDX));
		this.setEmail(customerInfo.get(EMAIL_IDX));
		this.setPhone1(customerInfo.get(PHONE1_IDX));
		this.setPhone2(customerInfo.get(PHONE2_IDX));
		this.setWeb(customerInfo.get(WEB_IDX));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
}
