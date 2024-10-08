package com.himanshu.bankApplication.Service;

import com.himanshu.bankApplication.Model.Customer;
import com.himanshu.bankApplication.Repository.CustomerRepo;
import com.himanshu.bankApplication.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService{
@Autowired
    private CustomerRepo customerRepo;


    @Override
    public List<Customer> getAllCustomer() {
        try{
            List<Customer> customerList=customerRepo.findAll();
            if(customerList.isEmpty()){
                throw new BusinessException("604","Hey list is completely empty we have nothing to return");
            }
            return customerList;
        }catch (Exception e){
            throw new BusinessException("605","Something went wrong in service layer while fetching all customer"+e.getMessage());
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        try {
            if(customer.getName().isEmpty() || customer.getName().length()==0){
                throw new BusinessException("601","Please send the proper name, it's blank");
            }
            Customer customer1=customerRepo.save(customer);
            return customer1;
        }catch (IllegalArgumentException e){
            throw new BusinessException("602", "Given employee is null"+e.getMessage());
        }catch (Exception e){
            throw new BusinessException("603","Something went wrong in service layer while saving customer"+e.getMessage());
        }
    }

    @Override
    public Customer getCustomerByAccountNum(long Account_num) {
        try{
            return customerRepo.findByAccountNum(Account_num);
        }catch (IllegalArgumentException e){
            throw new BusinessException("609","Given Account number is null, please send proper account number"+e.getMessage());
        }catch (java.util.NoSuchElementException e){
            throw new BusinessException("610","Given Account number is does not exist in database"+e.getMessage());
        }catch (Exception e){
            throw new BusinessException("611","Something went wrong in service layer"+e.getMessage());
        }
    }

    @Override
    public Customer getCustomerById(long id) {
        try{
            Customer customer=customerRepo.findById(id).get();
            return customer;
        }catch (IllegalArgumentException e){
            throw new BusinessException("606","Given customer id is null, please send some id to be searched"+e.getMessage());
        }catch (NoSuchElementException e){
            throw new BusinessException("607","Given customer id is does not exist in database "+e.getMessage());
        }catch (Exception e){
            throw new BusinessException("608","Something went wrong in service layer");
        }
    }

    @Override
    public List<Customer> getByName(String name) throws Exception{
        List<Customer> customerList=customerRepo.findByName(name);
        return customerList;
    }
}
