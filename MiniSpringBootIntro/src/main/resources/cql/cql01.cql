CREATE TABLE transaction_tmp (
    root_txn_id varchar,
    branch_id varchar,
    init_date timestamp,
    payment_content varchar,
    PRIMARY KEY ( root_txn_id )
);

INSERT INTO transaction_tmp (root_txn_id, branch_id, init_date, payment_content) VALUES
(
    '3E94R5-005312-7J2T4A-68H7F8',
    '100586772',
    '2020-05-20T11:18:31-0500',
    '5b6636f91f89bbf9da235eaa53c001c3fab2c976f4cae1a8c772540e4431d91ba36c6242f9a07a94680a6c7789c8d50e282be8e52378956dd761bb05bdf52b8a85d438aaf985f70b5bcd3a6e6b92f4c877a562c98420cef7e6ce802a73514746'
);
