package com.tpe.controller;


import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//kısayol: ctrl + shift + t
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    //baseURL/customers/1

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){

        Customer customer=customerService.getCustomerById(id);

        //return ResponseEntity.ok(customer);//200
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomerById(id);

        return ResponseEntity.ok("Customer is deleted.");
    }




}
