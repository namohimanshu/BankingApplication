package com.himanshu.bankApplication.Service;

import com.himanshu.bankApplication.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public List<Customer> getAllCustomer();
    public  Customer addCustomer(Customer customer);

}
