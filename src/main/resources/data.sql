INSERT INTO USER (ID, CREATE_AT, MODIFIED_AT, LAST_LOGIN_AT, EMAIL, IS_ACTIVE, NAME, PASSWORD)
VALUES (1001, SYSDATE(), SYSDATE(), SYSDATE(),'jsati@prb.cl', TRUE, 'sati', '$2a$10$U9d86pBNApiB4hQ5YBTN0uq59hdy7I5Ihx6uDplXDm6Xofmjh.FOK');
INSERT INTO PHONE (ID,NUMBER,CITY_CODE,CONTRY_CODE, CREATE_AT, MODIFIED_AT, USER_ID)
VALUES (100, '7654321','56', '32', SYSDATE(), SYSDATE(),1001);
INSERT INTO PHONE (ID,NUMBER,CITY_CODE,CONTRY_CODE, CREATE_AT, MODIFIED_AT, USER_ID)
VALUES (101, '456789','56', '32',SYSDATE(), SYSDATE(),1001);
-- user 2
INSERT INTO USER (ID, CREATE_AT, MODIFIED_AT, LAST_LOGIN_AT, EMAIL, IS_ACTIVE, NAME, PASSWORD)
VALUES (1002, SYSDATE(), SYSDATE(), SYSDATE(),'test@prb.cl', TRUE, 'user test', '$2a$10$U9d86pBNApiB4hQ5YBTN0uq59hdy7I5Ihx6uDplXDm6Xofmjh.FOK');
INSERT INTO PHONE (ID,NUMBER,CITY_CODE,CONTRY_CODE, CREATE_AT, MODIFIED_AT, USER_ID)
VALUES (102, '315462463','56', '32',SYSDATE(), SYSDATE(),1002);
INSERT INTO PHONE (ID,NUMBER,CITY_CODE,CONTRY_CODE, CREATE_AT, MODIFIED_AT, USER_ID)
VALUES (103, '88772622','56', '32',SYSDATE(), SYSDATE(),1002);
--user 3
INSERT INTO USER (ID, CREATE_AT, MODIFIED_AT, LAST_LOGIN_AT, EMAIL, IS_ACTIVE, NAME, PASSWORD)
VALUES (1003, SYSDATE(), SYSDATE(), SYSDATE(),'deseable@prb.cl', FALSE, 'user test', '$2a$10$U9d86pBNApiB4hQ5YBTN0uq59hdy7I5Ihx6uDplXDm6Xofmjh.FOK');
INSERT INTO PHONE (ID,NUMBER,CITY_CODE,CONTRY_CODE, CREATE_AT, MODIFIED_AT, USER_ID)
VALUES (104, '30061717','56', '32',SYSDATE(), SYSDATE(),1003);
INSERT INTO PHONE (ID,NUMBER,CITY_CODE,CONTRY_CODE, CREATE_AT, MODIFIED_AT, USER_ID)
VALUES (105, '898222','56', '32',SYSDATE(), SYSDATE(),1003);