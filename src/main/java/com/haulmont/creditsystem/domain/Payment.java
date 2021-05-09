package com.haulmont.creditsystem.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "payment_uuid")
    private UUID uuid;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty
    private LocalDate date;

    @Column(name = "total_amount")
    @NotEmpty
    private Long totalAmount;

    @Column(name = "principal_amount")
    @NotEmpty
    private Long principalAmount;

    @Column(name = "interest_amount")
    @NotEmpty
    private Long interestAmount;
}
