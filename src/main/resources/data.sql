insert into bank (bank_uuid, bank_name) values ('2780ebce353b45b79fc0dd09d48b1d3b', 'VTB')
insert into bank (bank_uuid, bank_name) values ('356a54263ab34e59895c44df5a9c105c', 'Sberbank')
insert into bank (bank_uuid, bank_name) values ('3f06af63a93c11e4979700505690773f', 'Raiffeisen')

insert into loan (loan_uuid, bank_uuid, interest_rate, loan_limit, loan_name) values ('1b8fbaf4916d42eea8e76db9c7d14219', '2780ebce353b45b79fc0dd09d48b1d3b', 0.353, 10000000, 'Autocredit')
insert into loan (loan_uuid, bank_uuid, interest_rate, loan_limit, loan_name) values ('9c463eabbf4641e381beb013002122bb', '2780ebce353b45b79fc0dd09d48b1d3b', 0.181, 500000, 'For VIP only')
insert into loan (loan_uuid, bank_uuid, interest_rate, loan_limit, loan_name) values ('f79d146a5d4d4a13be5617d5813865e5', '3f06af63a93c11e4979700505690773f', 0.021, 70000, 'Civilian')

insert into client (client_uuid, email, full_name, passport_number, phone_number) values ('447fcc6a741947128d4bcbd66bc2448a', 'ivan@ya.ru', 'Ivan Ivanov', '2000 123456', '9525554433')
insert into client (client_uuid, email, full_name, passport_number, phone_number) values ('5706a8b5ea7c4870938952225eeb419e', 'doe@usa.gov', 'John Doe', 'AB-123123', '555123123')

insert into loan_offer (loan_offer_uuid, amount, interest_total, client_uuid, first_payment_date, loan_uuid, loan_term) values ('b2c6d1e9a87e47109a49df1d5b7162d1', 20000, 300, '447fcc6a741947128d4bcbd66bc2448a', '2021-05-01', '1b8fbaf4916d42eea8e76db9c7d14219', 1)

insert into payment (payment_uuid, loan_offer_uuid, date, payment_amount,  principal_amount, interest_amount) values ('85f1811ced9c45a28bb585c2a07c71e6', 'b2c6d1e9a87e47109a49df1d5b7162d1', '2021-05-01', 20300, 20000, 300)