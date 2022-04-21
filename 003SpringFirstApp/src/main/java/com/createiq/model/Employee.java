package com.createiq.model;

public class Employee {

	private int eid;
	private String ename;
	private double esal;

	private Address address;

	public Employee(int eid, String ename, double esal, Address address) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", address=" + address + "]";
	}

}
