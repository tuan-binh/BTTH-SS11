package org.example.btthss11.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.btthss11.models.constants.TransferType;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransferType type;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

}
