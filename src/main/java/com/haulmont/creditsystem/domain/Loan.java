package com.haulmont.creditsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
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
    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private long limit;

    @Column(name = "interest_rate")
    @Min(value = 0)
    @Max(value = 99)
    //@DecimalMin("0.00")
    //@DecimalMax("99.00")
    private int interestRate;

    public Loan(String name, long limit, int interestRate) {
        this.name = name;
        this.limit = limit;
        this.interestRate = interestRate;
    }
}
