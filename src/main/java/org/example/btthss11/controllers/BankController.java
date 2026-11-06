package org.example.btthss11.controllers;

import lombok.RequiredArgsConstructor;
import org.example.btthss11.models.services.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/banks")
@RequiredArgsConstructor
public class BankController {
    private final TransferService transferService;

    @PutMapping
    public ResponseEntity<?> transferWithdraws(
            @RequestParam(name = "accountId") Long accountId,
            @RequestParam(name = "amount") Double amount
    ) {
        return ResponseEntity.status(200).body(transferService.processWithdrawal(accountId, amount));
    }

}
