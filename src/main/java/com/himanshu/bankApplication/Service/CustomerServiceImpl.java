package com.himanshu.bankApplication.Service;

import com.himanshu.bankApplication.Model.Customer;
import com.himanshu.bankApplication.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
@Autowired
    private CustomerRepo customerRepo;


    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList=customerRepo.findAll();
        return customerList;
    }
}
