package mk.iwec.payments.controller;

import mk.iwec.payments.Endpoints;
import mk.iwec.payments.dto.CustomerDTO;
import mk.iwec.payments.mapper.CustomerMapper;
import mk.iwec.payments.model.Customer;
import mk.iwec.payments.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Endpoints.CUSTOMER)
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerService.findAll();
        return customers.stream()
                .map(customerMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable UUID id) {
        Customer customer = customerService.findById(id);
        return customerMapper.entityToDto(customer);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CustomerDTO insert(@RequestBody Customer customer) {
        return customerMapper.entityToDto(customerService.insert(customer));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        customerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable UUID id, @RequestBody Customer customer) {
        return customerMapper.entityToDto(customerService.update(customer));
    }

}
