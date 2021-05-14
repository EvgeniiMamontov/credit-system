package com.haulmont.creditsystem.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @Column(name = "payment_amount")
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long paymentAmount;

    @Column(name = "principal_amount")
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long principalAmount;

    @Column(name = "interest_amount")
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long interestAmount;

    @ManyToOne
    @JoinColumn(name = "loan_offer_uuid")
    private LoanOffer loanOffer;

    public Payment(LocalDate date, long paymentAmount, long principalAmount, long interestAmount, LoanOffer loanOffer) {
        this.date = date;
        this.paymentAmount = paymentAmount;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
        this.loanOffer = loanOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(uuid, payment.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
