package com.haulmont.creditsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="loan_offer")
public class LoanOffer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "loan_offer_uuid")
    private UUID uuid;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_uuid")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_uuid")
    private Loan loan;

    @Column(name = "amount")
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long amount;

    @Column(name = "loan_term")
    @Min(value = 1)
    @Max(value = 240)
    private int loanTerm;

    @Column(name = "first_payment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> paymentSchedule;

    public LoanOffer(Client client, Loan loan, long amount, int loanTerm, LocalDate date, List<Payment> paymentSchedule) {
        this.client = client;
        this.loan = loan;
        this.amount = amount;
        this.loanTerm = loanTerm;
        this.date = date;
        this.paymentSchedule = paymentSchedule;
    }
}
