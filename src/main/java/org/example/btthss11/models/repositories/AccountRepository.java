package org.example.btthss11.models.repositories;

import org.example.btthss11.models.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
