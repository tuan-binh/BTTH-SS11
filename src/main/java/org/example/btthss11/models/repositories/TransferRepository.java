package org.example.btthss11.models.repositories;

import org.example.btthss11.models.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {
}
