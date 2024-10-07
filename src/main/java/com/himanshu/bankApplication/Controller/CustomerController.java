package com.himanshu.bankApplication.Controller;

import com.himanshu.bankApplication.Model.Customer;
import com.himanshu.bankApplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private CustomerService customerService;
    @GetMapping("test")
    public ResponseEntity<String> msg(){
        return new ResponseEntity<String>("Test", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer>customers=customerService.getAllCustomer();
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Customer>addCustomer(@RequestBody Customer customer){
        Customer customer1=customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);
    }
    @GetMapping("/accountNum/{account_num}")
    public ResponseEntity<Customer> getCustomerByAccount (@PathVariable long account_num){
        Customer customer=customerService.getCustomerByAccountNum(account_num);
        return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Customer>> getCustomerByName (@PathVariable String name){
        List<Customer> customers=customerService.getByName(name);
        return new ResponseEntity<List<Customer>>(customers,HttpStatus.ACCEPTED);
    }


}
