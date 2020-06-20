package com.example.demo.dto;

public class NewTicketDto {

	private String personName1;
	private String personName2;
	private String personName3;
	private String personName4;
	private String personName5;
	private int noOfPerson;
	private String category;
	private int pageSize;
	private int pageIndex;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPersonName1() {
		return personName1;
	}

	public void setPersonName1(String personName1) {
		this.personName1 = personName1;
	}

	public String getPersonName2() {
		return personName2;
	}

	public void setPersonName2(String personName2) {
		this.personName2 = personName2;
	}

	public String getPersonName3() {
		return personName3;
	}

	public void setPersonName3(String personName3) {
		this.personName3 = personName3;
	}

	public String getPersonName4() {
		return personName4;
	}

	public void setPersonName4(String personName4) {
		this.personName4 = personName4;
	}

	public String getPersonName5() {
		return personName5;
	}

	public void setPersonName5(String personName5) {
		this.personName5 = personName5;
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
