package com.haulmont.creditsystem.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    private LocalDate date;

    @Column(name = "total_amount")
    @NotEmpty
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long totalAmount;

    @Column(name = "principal_amount")
    @NotEmpty
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long principalAmount;

    @Column(name = "interest_amount")
    @NotEmpty
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long interestAmount;
}
