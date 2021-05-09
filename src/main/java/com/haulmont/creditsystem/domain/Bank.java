package com.haulmont.creditsystem.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bank")
public class Bank {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "bank_uuid")
    private UUID uuid;

    @Column(name = "bank_name")
    @NotEmpty
    private String name;

    @OneToMany(mappedBy="bank", fetch = FetchType.LAZY)
    private Set<Loan> loans;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Client> clients;

    public Bank(String name) {
        this.name = name;
    }
}
