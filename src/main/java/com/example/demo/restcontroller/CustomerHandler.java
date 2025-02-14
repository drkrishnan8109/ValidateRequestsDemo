package com.example.demo.restcontroller;

import com.example.demo.model.Customer;
import com.example.demo.service.RequestReceiverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@Api(tags = {"customer"})
public class CustomerHandler {

    @Autowired
    private RequestReceiverService requestReceiverService;

    //TODO Use JWT for authorization
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"}, // use protobuf for faster serDe and improve latency
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a customer resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createCustomer(@RequestBody Customer customer,
                               HttpServletRequest request, HttpServletResponse response) {
        Customer createdCustomer = this.requestReceiverService.createCustomer(customer);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdCustomer.getCustomerId()).toString());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable Integer customerId) {
        Customer customer = this.requestReceiverService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> customerList = this.requestReceiverService.getCustomers();
        return ResponseEntity.ok(customerList);
    }
}
