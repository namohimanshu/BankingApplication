package com.himanshu.bankApplication.Controller;

import com.himanshu.bankApplication.Model.Customer;
import com.himanshu.bankApplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
