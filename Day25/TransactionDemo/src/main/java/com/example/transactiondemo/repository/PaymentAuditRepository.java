package com.example.transactiondemo.repository;

import com.example.transactiondemo.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit,Long> {
}
