package com.example.transactiondemo.repository;

import com.example.transactiondemo.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord,Long> {
}
