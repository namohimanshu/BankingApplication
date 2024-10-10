package com.himanshu.bankApplication.Service;

import com.himanshu.bankApplication.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    public List<Customer> getAllCustomer();
    public  Customer addCustomer(Customer customer);
    //
    public Customer getCustomerByAccountNum (long Account_num);

    public Optional<Customer> getCustomerById(long id);
    public  List<Customer> getByName(String name);

    public String deleteCustomerById(long customerId);


    public Customer updateCustomer(com.himanshu.bankApplication.Model.Customer customer, Long customerId);

    public String deleteCustomerByAccountNum(long accountNum);
}
