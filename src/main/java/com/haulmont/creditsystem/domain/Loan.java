package com.haulmont.creditsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    private String name;

    @Column(name = "loan_limit")
    private long limit;

    @Column(name = "interest_rate")
    private int interestRate;

    public Loan(String name, long limit, int interestRate) {
        this.name = name;
        this.limit = limit;
        this.interestRate = interestRate;
    }
}
