package com.haulmont.creditsystem.domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;

@Data
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
    private String fullName;

    @Column(name = "phone_number")
    @NotEmpty
    private String phoneNumber;

    @Column(name = "email")
    @NotEmpty
    private String email;

    @Column(name = "passport_number")
    @NotEmpty
    private String passportNumber;

    public Client(@NonNull String fullName, String phoneNumber, String email, String passportNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
    }
}
