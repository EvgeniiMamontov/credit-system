package com.haulmont.creditsystem.repository;

import com.haulmont.creditsystem.domain.LoanOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanOfferRepository extends JpaRepository<LoanOffer, Long> {
    LoanOffer findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}
