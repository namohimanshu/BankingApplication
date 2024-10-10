package com.himanshu.bankApplication.Service;

import com.himanshu.bankApplication.Model.Customer;
import com.himanshu.bankApplication.Repository.CustomerRepo;
import com.himanshu.bankApplication.exceptions.BusinessException;
import com.himanshu.bankApplication.exceptions.CustomException;
import com.himanshu.bankApplication.exceptions.customerWithNameNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        try{  Customer customer=    customerRepo.findByAccountNum(Account_num);
            if (customer !=null)
                return customer;
            else
                throw new BusinessException();



        }catch (BusinessException e){
            throw new BusinessException("610","Given Account number  does not exist in database"+e.getMessage());
        }catch (Exception e){
            throw new BusinessException("611","Something went wrong in service layer"+e.getMessage());
        }
    }

  //  @Override
//    public Customer getCustomerById(long id) {
//        try{
//            Customer customer=customerRepo.findById(id).get();
//            return customer;
//        }catch (IllegalArgumentException e){
//            throw new BusinessException("606","Given customer id is null, please send some id to be searched"+e.getMessage());
//        }catch (NoSuchElementException e){
//            throw new BusinessException("607","Given customer id is does not exist in database "+e.getMessage());
//        }catch (Exception e){
//            throw new BusinessException("608","Something went wrong in service layer");
//        }
//    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> customerList=customerRepo.findByName(name);
        if (customerList.isEmpty())
            throw new customerWithNameNotFound("Customer with name: "+name+" not exist");
        else
                return customerList;

    }

    @Override
    public String deleteCustomerById(long customerId) {
        customerRepo.findById(customerId).orElseThrow( ()-> new BusinessException() );
       customerRepo.deleteById(customerId);

        return "deleted";
    }

    public Optional<Customer> getCustomerById(long id)  {
      Optional<Customer> c=  customerRepo.findById(id);
       if (c.isPresent()){
           return c ;
       }
       else {
           throw new CustomException("customer Not Found");
       }
    }
}
