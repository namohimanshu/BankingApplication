package com.himanshu.bankApplication.Controller;

import com.himanshu.bankApplication.Model.Customer;
import com.himanshu.bankApplication.Service.CustomerService;
import com.himanshu.bankApplication.exceptions.BusinessException;
import com.himanshu.bankApplication.exceptions.ControllerException;
import com.himanshu.bankApplication.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private CustomerService customerService;

//@Autowired
//private ControllerException controllerException;


//    @GetMapping("/Id/{id}")
//    public ResponseEntity<?> getById(@PathVariable long id){
//        try{
//            Customer customer= customerService.getCustomerById(id);
//            return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);
//        }catch (BusinessException e){
//            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
//            return new ResponseEntity<>(ce, HttpStatus.NOT_FOUND);
//        }catch (Exception e){
//            ControllerException ce = new ControllerException("703","something went wrong in controller layer");
//            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
//        }
//
//    }

    @GetMapping("test")
    public ResponseEntity<String> msg(){
        return new ResponseEntity<String>("Test", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() throws BusinessException {
        List<Customer>customers=customerService.getAllCustomer();
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>addCustomer(@RequestBody Customer customer){
        try{
            Customer customer1=customerService.addCustomer(customer);
            return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);
        }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException ce = new ControllerException("701","Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/accountNum/{account_num}")
    public ResponseEntity<?> getCustomerByAccount (@PathVariable long account_num){
        try{
            Customer customer=customerService.getCustomerByAccountNum(account_num);
            return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException ce = new ControllerException("702","Something went wrong in controller while fetching customer by account number");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Customer>> getCustomerByName (@PathVariable String name) {
        List<Customer> customers=customerService.getByName(name);
        return new ResponseEntity<List<Customer>>(customers,HttpStatus.ACCEPTED);
    }


    @GetMapping("/Id/{id}")
    public ResponseEntity<Optional<Customer>> getById(@PathVariable long id){

       Optional<Customer> c=customerService.getCustomerById(id);
            return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @DeleteMapping ("/Id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {

        customerService.deleteCustomerById(id);
        String c = new String("deleted");
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @RequestParam Long customerId){
        return new ResponseEntity<>(customerService.updateCustomer(customer,customerId),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomerByAccountNum(@RequestParam("accountNum") long accountNum){
        String msg=customerService.deleteCustomerByAccountNum(accountNum);
        return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
    }

}
