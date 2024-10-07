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

    @Override
    public Customer addCustomer(Customer customer) {
       Customer customer1=customerRepo.save(customer);
       return customer1;
    }

    @Override
    public Customer getCustomerByAccountNum(long Account_num) {
        Customer customer =customerRepo.findByAccountNum(Account_num);
        return customer;
    }

    @Override
    public Customer getCustomerById(long id) {
         Customer customer=customerRepo.findById(id).get();
         return customer;
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> customerList=customerRepo.findByName(name);
        return customerList;
    }
}
