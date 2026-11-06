package org.example.btthss11.models.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.btthss11.exceptions.HttpNotFoundException;
import org.example.btthss11.exceptions.InsufficientBalanceException;
import org.example.btthss11.models.constants.TransferType;
import org.example.btthss11.models.entities.Account;
import org.example.btthss11.models.entities.Transfer;
import org.example.btthss11.models.repositories.AccountRepository;
import org.example.btthss11.models.repositories.TransferRepository;
import org.example.btthss11.models.services.TransferService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Override
    public Transfer processWithdrawal(Long accountId, Double amount) {
        log.info("Thông tin tài khoản {} với số tiền là {}", accountId, amount);
        // Tìm account có tồn tại hay không
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new HttpNotFoundException("Account not found with id = " + accountId));
        // Trừ tiền tài khoản đó
        log.debug("Số tiền muốn rút {}", amount);
        log.debug("Số dư tài khoản {}", account.getBalance());
        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException("Not enough your balance");
        }
        log.debug("Số tiền còn lại {}", account.getBalance() - amount);
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
        // Tạo một lịch sử giao dịch mới
        Transfer transfer = Transfer.builder()
                .type(TransferType.WITHDRAW)
                .amount(amount)
                .transferDate(LocalDateTime.now())
                .build();
        // Lưu lại
        return transferRepository.save(transfer);
    }
}
