package com.himanshu.bankApplication.Service;

import com.himanshu.bankApplication.Model.Customer;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public List<Customer> getAllCustomer();
    public  Customer addCustomer(Customer customer);
    public Customer getCustomerByAccountNum (long Account_num);
    public Customer getCustomerById(Long id);

}
