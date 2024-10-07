package com.himanshu.bankApplication.Repository;

import com.himanshu.bankApplication.Model.Address;
import com.himanshu.bankApplication.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
