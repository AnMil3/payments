package mk.iwec.payments.controller;

import mk.iwec.payments.Endpoints;
import mk.iwec.payments.dto.PaymentDTO;
import mk.iwec.payments.mapper.PaymentMapper;
import mk.iwec.payments.model.Payment;
import mk.iwec.payments.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Endpoints.PAYMENT)
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @GetMapping
    public List<PaymentDTO> findAll() {
        List<Payment> payments = paymentService.findAll();
        return payments.stream()
                .map(paymentMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable UUID id) {
        Payment payment = paymentService.findById(id);
        return paymentMapper.entityToDto(payment);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PaymentDTO insert(@RequestBody Payment payment) {
        return paymentMapper.entityToDto(paymentService.insert(payment));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        paymentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public PaymentDTO update(@PathVariable UUID id, @RequestBody Payment payment) {
        return paymentMapper.entityToDto(paymentService.update(payment));
    }

}
