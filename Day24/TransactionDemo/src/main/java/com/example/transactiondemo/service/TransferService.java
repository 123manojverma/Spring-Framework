package com.example.transactiondemo.service;

import com.example.transactiondemo.entity.Account;
import com.example.transactiondemo.entity.TransferRecord;
import com.example.transactiondemo.repository.AccountRepository;
import com.example.transactiondemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount){
        Account fromAccount=accountRepository.findById(fromAccountId).orElseThrow(()->new RuntimeException("User not found"));
        Account toAccount=accountRepository.findById(toAccountId).orElseThrow(()->new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        toAccount.creditAccount(amount);
        transferRepository.save(new TransferRecord(
                fromAccountId,toAccountId,amount, LocalDate.now()
        ));
    }
}
