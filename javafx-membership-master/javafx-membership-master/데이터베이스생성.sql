CREATE TABLE admin_accounts
(
    idx                 NUMBER(4)    NOT NULL,
    admin_id            VARCHAR2(50) NOT NULL,
    admin_password      VARCHAR2(50) NOT NULL
);
ALTER TABLE admin_accounts ADD
(
    CONSTRAINT admin_idx_pk PRIMARY KEY(idx)
);
CREATE SEQUENCE admin_idx_seq START WITH 1;
INSERT INTO admin_accounts
(idx, admin_id, admin_password)
VALUES
(admin_idx_seq.NEXTVAL, 'admin', 'admin1');



CREATE TABLE member_accounts
(
    idx             NUMBER(4)       NOT NULL,
    user_name       VARCHAR2(50)    NOT NULL,
    user_gender     VARCHAR2(50)    NOT NULL,
    class_name      VARCHAR2(50)    NOT NULL,
    class_num       NUMBER(3)       NOT NULL,
    city            VARCHAR2(50)    NOT NULL,
    jungbo          VARCHAR2(50)    NOT NULL
);
ALTER TABLE member_accounts ADD
(
    CONSTRAINT member_idx_pk PRIMARY KEY (idx)
);
CREATE SEQUENCE member_idx_seq START WITH 1;

INSERT INTO member_accounts
(idx, user_name, user_gender, class_name, class_num, city, jungbo)
VALUES
(member_idx_seq.NEXTVAL, '송별회', '남', '자바프로그래밍', '505', '안산시', 'O');









