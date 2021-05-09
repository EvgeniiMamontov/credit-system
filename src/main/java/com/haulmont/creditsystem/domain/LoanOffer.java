package com.haulmont.creditsystem.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

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

    //клиент
    //кредит
    //сумма кредита
    //дата первого платежа

    //график платежей?????
        //дата платежа
        //сумма платежа
        //сумма гашения тела кредита
        //сумма гашения процентов
}
