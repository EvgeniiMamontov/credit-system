package com.haulmont.creditsystem.domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "client_uuid")
    private UUID uuid;

    @Column(name = "full_name")
    @NotEmpty
    @Size(min = 5, max = 100)
    private String fullName;

    @Column(name = "phone_number")
    @NotEmpty
    @Digits(integer=15, fraction=0)
    private String phoneNumber;

    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "passport_number")
    @NotEmpty
    @Size(min = 5, max = 20)
    private String passportNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LoanOffer> loanOffers;

    public Client(@NonNull String fullName, String phoneNumber, String email, String passportNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
    }
}
