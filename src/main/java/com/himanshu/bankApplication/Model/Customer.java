package com.himanshu.bankApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
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

}


