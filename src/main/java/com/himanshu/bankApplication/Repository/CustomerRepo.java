package com.himanshu.bankApplication.Repository;

import com.himanshu.bankApplication.Model.Address;
import com.himanshu.bankApplication.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    public Customer findByAccountNum(long account_num);
    public List<Customer> findByName (String name);
}
