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

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (1, '김태영', '남', '3D MAX', '501', '시흥시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (2, '박은지', '여', '3D MAX', '501', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (3, '김하늘', '여', '3D MAX', '501', '화성시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (4, '홍명보', '남', '3D MAX', '501', '시흥시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (5, '이운재', '남', '3D MAX', '501', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (6, '박주영', '남', '3D MAX', '501', '화성시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (7, '박지성', '남', '3D MAX', '501', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (8, '서은지', '여', '3D MAX', '501', '화성시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (9, '현영민', '남', '3D MAX', '501', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (10, '장미란', '여', '3D MAX', '501', '시흥시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (11, '현아영', '여', '3D MAX', '501', '서울시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (12, '강준구', '남', '3D MAX', '501', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (13, '김병지', '남', '3D MAX', '501', '시흥시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (14, '이운재', '남', '3D MAX', '501', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (15, '최은성', '여', '3D MAX', '501', '안양시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (16, '김연경', '여', '3D MAX', '501', '안양시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (17, '염혜선', '여', '3D MAX', '501', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (18, '유상철', '여', '3D MAX', '501', '서울시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (19, '김남일', '남', '3D MAX', '501', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (20, '양효진', '여', '3D MAX', '501', '수원시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('21', '강민춘', '남', '웹퍼블리셔', '502', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('22', '이한수', '여', '웹퍼블리셔', '502', '시흥시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('23', '서혜리', '여', '웹퍼블리셔', '502', '인천', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('24', '표한결', '남', '웹퍼블리셔', '502', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('25', '백조은', '여', '웹퍼블리셔', '502', '시흥시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('26', '류오성', '남', '웹퍼블리셔', '502', '수원시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('27', '남장미', '여', '웹퍼블리셔', '502', '수원시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('28', '유미란', '여', '웹퍼블리셔', '502', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('29', '안장미', '여', '웹퍼블리셔', '502', '시흥시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('30', '정윤준', '남', '웹퍼블리셔', '502', '인천', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('31', '유미란', '여', '웹퍼블리셔', '502', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('32', '정나래', '여', '웹퍼블리셔', '502', '수원시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('33', '오남규', '남', '웹퍼블리셔', '502', '인천', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('34', '고덕수', '남', '웹퍼블리셔', '502', '수원시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('35', '탁재범', '남', '웹퍼블리셔', '502', '부천시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('36', '이민서', '여', '웹퍼블리셔', '502', '부천시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('37', '표은채', '여', '웹퍼블리셔', '502', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('38', '이광조', '남', '웹퍼블리셔', '502', '부천시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('39', '신경택', '남', '웹퍼블리셔', '502', '시흥시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo) values ('40', '유미란', '여', '웹퍼블리셔', '502', '안산시', 'O');

insert into member_accounts
values (41, '마동석', '남', '자바 프로그래밍', 503, '안산시', 'o');

insert into member_accounts
values (42, '권혁수', '남', '자바 프로그래밍', 503, '화성시', 'x');

insert into member_accounts
values (43, '김윤석', '남', '자바 프로그래밍', 503, '안산시', 'o');

insert into member_accounts
values (44, '강소라', '여', '자바 프로그래밍', 503, '수원시', 'o');

insert into member_accounts
values (45, '전지현', '여', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (46, '박보영', '여', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (47, '이정재', '남', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (48, '정우성', '남', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (49, '권혁수', '남', '자바 프로그래밍', 503, '시흥시', 'x');

insert into member_accounts
values (50, '공효진', '여', '자바 프로그래밍', 503, '수원시', 'x');

insert into member_accounts
values (51, '송혜교', '여', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (52, '손석구', '남', '자바 프로그래밍', 503, '수원시', 'x');

insert into member_accounts
values (53, '이지은', '여', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (54, '유해진', '남', '자바 프로그래밍', 503, '서울시', 'o');

insert into member_accounts
values (55, '박서준', '남', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (56, '류덕환', '남', '자바 프로그래밍', 503, '수원시', 'x');

insert into member_accounts
values (57, '송강호', '남', '자바 프로그래밍', 503, '화성시', 'x');

insert into member_accounts
values (58, '전도연', '여', '자바 프로그래밍', 503, '시흥시', 'x');

insert into member_accounts
values (59, '이승기', '남', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (60, '고창석', '남', '자바 프로그래밍', 503, '안산시', 'x');

insert into member_accounts
values (61, '강호동', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (62, '유재석', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (63, '전현무', '남', '자바 프로그래밍', 504, '화성시', 'x');

insert into member_accounts
values (64, '신동엽', '남', '자바 프로그래밍', 504, '시흥시', 'x');

insert into member_accounts
values (65, '이경규', '남', '자바 프로그래밍', 504, '용인시', 'o');

insert into member_accounts
values (66, '이지은', '여', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (67, '정려원', '여', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (68, '소지섭', '남', '자바 프로그래밍', 504, '안산시', 'o');

insert into member_accounts
values (69, '양세찬', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (70, '정준하', '남', '자바 프로그래밍', 504, '수원시', 'x');

insert into member_accounts
values (71, '이광수', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (72, '전소민', '여', '자바 프로그래밍', 504, '안산시', 'o');

insert into member_accounts
values (73, '오나라', '여', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (74, '이선균', '남', '자바 프로그래밍', 504, '수원시', 'x');

insert into member_accounts
values (75, '옥동자', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (76, '윤석열', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (77, '이재명', '남', '자바 프로그래밍', 504, '수원시', 'x');

insert into member_accounts
values (78, '문재인', '남', '자바 프로그래밍', 504, '시흥시', 'o');

insert into member_accounts
values (79, '김정은', '남', '자바 프로그래밍', 504, '안산시', 'x');

insert into member_accounts
values (80, '김태희', '여', '자바 프로그래밍', 504, '화성시', 'x');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (81, '복우주', '남', '풀스택 마스터', 505, '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (82, '봉상준', '남', '풀스택 마스터', '505', '인천', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (83, '서수정', '여', '풀스택 마스터', '505', '안양시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (84, '추우영', '남', '풀스택 마스터', '505', '수원시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (85, '풍형기', '남', '풀스택 마스터', '505', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (86, '이상학', '남', '풀스택 마스터', '505', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (87, '황보석진', '남', '풀스택 마스터', '505', '시흥시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (88, '신민수', '남', '풀스택 마스터', '505', '부천시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (89, '심수경', '여', '풀스택 마스터', '505', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (90, '하예영', '여', '풀스택 마스터', '505', '부천시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (91, '추서언', '남', '풀스택 마스터', '505', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (92, '송재윤', '남', '풀스택 마스터', '505', '안양시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (93, '허성희', '여', '풀스택 마스터', '505', '시흥시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (94, '제갈선우', '남', '풀스택 마스터', '505', '인천시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (95, '오은주', '여', '풀스택 마스터', '505', '안양시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (96, '추민훈', '남', '풀스택 마스터', '505', '안산시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (97, '하용현', '남', '풀스택 마스터', '505', '수원시', 'O');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (98, '최원경', '남', '풀스택 마스터', '505', '안산시', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (99, '정종훈', '남', '풀스택 마스터', '505', '인천', 'X');

insert into member_accounts(idx, user_name, user_gender, class_name, class_num, city, jungbo)
values (100, '권주혜', '여', '풀스택 마스터', '505', '수원시', 'X');





