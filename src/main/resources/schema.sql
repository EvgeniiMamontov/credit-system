DROP TABLE IF EXISTS bank CASCADE 
DROP TABLE IF EXISTS bank_client CASCADE 
DROP TABLE IF EXISTS client CASCADE 
DROP TABLE IF EXISTS loan CASCADE 
DROP TABLE IF EXISTS loan_offer CASCADE 
DROP TABLE IF EXISTS payment CASCADE 

CREATE TABLE bank (
	bank_uuid binary(16) not null,
        bank_name varchar(50),
        primary key (bank_uuid)
);
    
CREATE TABLE bank_client (
	bank_uuid binary(16) not null,
        client_uuid binary(16) not null,
        primary key (bank_uuid, client_uuid)
);

CREATE TABLE client (
	client_uuid binary(16) not null,
	    full_name varchar(100),
	    phone_number varchar(15),
        email varchar(320),
        passport_number varchar(20),
        primary key (client_uuid)
);

CREATE TABLE loan (
	loan_uuid binary(16) not null,
	    loan_name varchar(50),
        loan_limit bigint check (loan_limit>=1 AND loan_limit<=99999999999),
        interest_rate float(24),
        bank_uuid binary(16),
        primary key (loan_uuid)
);

    
CREATE TABLE loan_offer (
	loan_offer_uuid binary(16) not null,
	    client_uuid binary(16),
        loan_uuid binary(16),
        amount bigint check (amount>=1 AND amount<=99999999999),
        interest_total bigint check (interest_total>=1 AND interest_total<=99999999999),
        loan_term integer check (loan_term>=1 AND loan_term<=240),
        first_payment_date date,
        primary key (loan_offer_uuid)
);

CREATE TABLE payment (
	payment_uuid binary(16) not null,
        date date,
        payment_amount bigint check (payment_amount>=0 AND payment_amount<=99999999999),
        principal_amount bigint check (principal_amount>=0 AND principal_amount<=99999999999),
        interest_amount bigint check (interest_amount>=0 AND interest_amount<=99999999999),
        loan_offer_uuid binary(16),
        primary key (payment_uuid)
);
    
ALTER TABLE bank_client 
	add constraint FK_bank_client_client
	foreign key (client_uuid) 
	references client
    
ALTER TABLE bank_client
       add constraint FK_bank_client_bank
       foreign key (bank_uuid) 
       references bank
 
ALTER TABLE loan 
       add constraint FK_loan_bank
       foreign key (bank_uuid) 
       references bank
    
ALTER TABLE loan_offer 
       add constraint FK_loan_offer_client
       foreign key (client_uuid) 
       references client
    
ALTER TABLE loan_offer 
       add constraint FK_loan_offer_loan
       foreign key (loan_uuid) 
       references loan
    
ALTER TABLE payment 
       add constraint FK_payment_loan_offer
       foreign key (loan_offer_uuid) 
       references loan_offer