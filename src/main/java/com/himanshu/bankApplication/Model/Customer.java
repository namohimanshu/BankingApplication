package com.himanshu.bankApplication.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String name;
	private String gender;

	private final long accountNum;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "customerId")
	private List<Address> address;


	// Default constructor required by JPA
	protected Customer() {
	this.accountNum = getAccountNum();

	}

	// Constructor for setting account_num (since it's final)
//	public Customer(long account_num) {
//		this.account_num = account_num;
//	}

	public Customer(long customerId, String name, String gender, long accountNum, List<Address> address) {
		this.customerId = customerId;
		this.name = name;
		this.gender = gender;
		this.accountNum = accountNum;
		this.address = address;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public long getAccountNum() {
		return accountNum;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Customer{" +
				"customerId=" + customerId +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", account_num=" + accountNum +
				", address=" + address +
				'}';
	}
}


