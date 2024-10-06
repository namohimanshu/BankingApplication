package com.himanshu.bankApplication.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String name;
	private String gender;

	private final long account_num;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "customerId")
	private List<Address> address;


//	public Customer(String customer_id, String name, String gender, long account_num, Address address) {
//		this.customer_id = customer_id;
//		this.name = name;
//		this.gender = gender;
//		this.account_num = account_num;
//		this.address = address;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//	public long getAccount_num() {
//		return Account_num;
//	}
//
////	public long setAccount_num(long acc_num) {
////		this.Account_num=acc_num;
////	}
//	@Override
//	public String toString() {
//		return "Customer [name=" + name + ", gender=" + gender + ", Account_num=" + Account_num + ", address=" + address
//				+ "]";
//	}
//
//
}


