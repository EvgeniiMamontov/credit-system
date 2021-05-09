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

    //список кредитов
    //список клиентов


    public Bank(String name) {
        this.name = name;
    }
}
