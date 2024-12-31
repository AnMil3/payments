package mk.iwec.payments.service;

import lombok.extern.slf4j.Slf4j;
import mk.iwec.payments.exception.ResourceNotFoundException;
import mk.iwec.payments.model.Payment;
import mk.iwec.payments.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment findById(UUID id) {
        log.debug("Execute findById with id {}", id);

        return paymentRepository.findById(id).orElseThrow(() -> {
            log.error("Payment with id {} is not found", id);
            return new ResourceNotFoundException("Payment not found");
        });
    }

    public List<Payment> findAll() {
        log.debug("Execute findAll");

        return paymentRepository.findAll();
    }

    public Payment insert(Payment payment) {
        log.debug("Execute insert with parameter {}", payment);

        return paymentRepository.save(payment);
    }

    public void deleteById(UUID id) {
        log.debug("Execute deleteById with id {}", id);

        paymentRepository.deleteById(id);
    }

    public Payment update(Payment payment) {
        log.debug("Execute update with parameter {}", payment);

        return paymentRepository.save(payment);
    }

}
