package com.himanshu.bankApplication.Model;

public class Customer {
	private String name;
	private String gender;
    private final long Account_num ;
	private Address address;
	public Customer(String name, String gender, long account_num, Address address) {
		super();
		this.name = name;
		this.gender = gender;
		this.Account_num = account_num;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getAccount_num() {
		return Account_num;
	}
	
//	public long setAccount_num(long acc_num) {
//		this.Account_num=acc_num;
//	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", Account_num=" + Account_num + ", address=" + address
				+ "]";
	}
	
	
	
	

}
