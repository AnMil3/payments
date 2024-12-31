package mk.iwec.payments.service;

import lombok.extern.slf4j.Slf4j;
import mk.iwec.payments.exception.ResourceNotFoundException;
import mk.iwec.payments.model.Customer;
import mk.iwec.payments.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(UUID id) {
        log.debug("Execute findById with id {}", id);

        return customerRepository.findById(id).orElseThrow(() -> {
            log.error("Error: Customer with id {} is not found", id);
            return new ResourceNotFoundException("Customer not found");
        });
    }

    public List<Customer> findAll() {
        log.debug("Execute findAll");

        return customerRepository.findAll();
    }

    public Customer insert(Customer customer) {
        log.debug("Execute insert with parameter {}", customer);

        return customerRepository.save(customer);
    }

    public void deleteById(UUID id) {
        log.debug("Execute deleteById with id {}", id);

        customerRepository.deleteById(id);
    }

    public Customer update(Customer customer) {
        log.debug("Execute update with parameter {}", customer);

        return customerRepository.save(customer);
    }
}
