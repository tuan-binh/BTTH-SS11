package org.example.btthss11.models.services;

import org.example.btthss11.models.entities.Transfer;

public interface TransferService {
    Transfer processWithdrawal(Long accountId,Double amount);
}
