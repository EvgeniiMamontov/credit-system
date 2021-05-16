package com.haulmont.creditsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="loan_offer")
public class LoanOffer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "loan_offer_uuid")
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_uuid")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_uuid")
    private Loan loan;

    @Column(name = "amount")
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long amount;

    @Column(name = "interest_total")
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long interestTotal;

    @Column(name = "loan_term")
    @Min(value = 1)
    @Max(value = 240)
    private int loanTerm;

    @Column(name = "first_payment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @OneToMany(mappedBy = "loanOffer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> paymentSchedule;

    public LoanOffer(UUID uuid, Client client, Loan loan, long amount, int loanTerm, LocalDate date) {
        this.uuid = uuid;
        this.client = client;
        this.loan = loan;
        this.amount = amount;
        this.loanTerm = loanTerm;
        this.date = date;
        this.paymentSchedule = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanOffer loanOffer = (LoanOffer) o;
        return Objects.equals(uuid, loanOffer.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
