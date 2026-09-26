package com.example.transactiondemo.service;

import com.example.transactiondemo.entity.Order;
import com.example.transactiondemo.entity.PaymentAudit;
import com.example.transactiondemo.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 5)
    public void audit(Order order) {
        PaymentAudit paymentAudit = new PaymentAudit(order.getAmount(), order.getId(), true);

        paymentAuditRepository.save(paymentAudit);
    }
}
