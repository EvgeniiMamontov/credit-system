package com.haulmont.creditsystem.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="loan")
public class Loan {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "loan_uuid")
    private UUID uuid;

    @Column(name = "loan_name")
    @NotEmpty
    @Size(min = 5, max = 50)
    private String name;

    @Column(name = "loan_limit")
    @Min(value = 1)
    @Max(value = Long.MAX_VALUE)
    private long limit;

    @Column(name = "interest_rate")
    @DecimalMin("0")
    @DecimalMax("100")
    private float interestRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_uuid")
    private Bank bank;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LoanOffer> loanOffers;

    public Loan(String name, long limit, float interestRate, Bank bank) {
        this.name = name;
        this.limit = limit;
        this.interestRate = interestRate;
        this.bank = bank;
    }
}
