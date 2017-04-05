

INSERT INTO USERS (ID, LOGIN, FIRST_NAME, MIDDLE_NAME, SURNAME, EMAIL, PHONE, CREATE_DATE, CONFIRMED_DATE, BLOCK_DATE, ROLES, PASSWORD) VALUES (1, 'user', 'Adam', 'Michał', 'Kowalski', null,null,'2017-03-11','2017-03-11',null,'USER', '$2a$10$SEG/cPLdMESrZN5nM2DSUuOSYmCx2vxiHmNGSmtg5PQaA53IOhA4i');
INSERT INTO USERS (ID, LOGIN, FIRST_NAME, MIDDLE_NAME, SURNAME, EMAIL, PHONE, CREATE_DATE, CONFIRMED_DATE, BLOCK_DATE, ROLES, PASSWORD) VALUES (2, 'admin', 'Jan', null, 'Nowak', null,null,'2017-03-11','2017-03-11',null,'ADMIN','$2a$10$SEG/cPLdMESrZN5nM2DSUuOSYmCx2vxiHmNGSmtg5PQaA53IOhA4i');

INSERT INTO CREDIT_CARD (ID, USER_ID, KIND, NUMBER, EXPIRED_DATE, CVV) VALUES (1,1,'V', '4556 7455 1910 9763', '2020-02-11', '592');
INSERT INTO CREDIT_CARD (ID, USER_ID, KIND, NUMBER, EXPIRED_DATE, CVV) VALUES (2,1,'M', '5522 5298 9397 2337', '2020-02-11', '742');
INSERT INTO CREDIT_CARD (ID, USER_ID, KIND, NUMBER, EXPIRED_DATE, CVV) VALUES (3,1,'AE', '3736 534229 85627', '2020-02-11', '374');

INSERT INTO CREDIT_CARD (ID, USER_ID, KIND, NUMBER, EXPIRED_DATE, CVV) VALUES (4,2,'V', '4539 5734 0569 2706', '2017-09-30', '434');
INSERT INTO CREDIT_CARD (ID, USER_ID, KIND, NUMBER, EXPIRED_DATE, CVV) VALUES (5,2,'M', '5153 3275 7983 6223', '2019-03-31', '629');
INSERT INTO CREDIT_CARD (ID, USER_ID, KIND, NUMBER, EXPIRED_DATE, CVV) VALUES (6,2,'AE', '3775 607951 49424', '2017-05-31', '432');