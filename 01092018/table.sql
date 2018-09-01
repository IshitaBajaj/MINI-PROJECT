CREATE SEQUENCE C_seq
START WITH 1000
INCREMENT BY 1;

CREATE SEQUENCE A_seq
START WITH 10000
INCREMENT BY 1;

CREATE TABLE Composer_Master
(Composer_id NUMBER(6),
Composer_Name VARCHAR2(50),
Composer_BornDate DATE,
Composer_DiedDate DATE,
Composer_CaeipiNumber VARCHAR2(10),
Composer_MusicSocietyID CHAR(3),
Created_By NUMBER(6),
Created_On DATE,
Updated_By NUMBER(6),
Updated_On DATE,
Composer_DeletedFlag char(1),
CONSTRAINT Composer_Master_pk PRIMARY KEY(Composer_id));

CREATE TABLE User_Master
(user_id NUMBER(6),
user_password VARCHAR2(20),
created_by NUMBER(6),
created_on DATE,
updated_by NUMBER(6),
updated_on DATE,
user_type char(1),
CONSTRAINT User_Master_pk PRIMARY KEY(User_id));

CREATE TABLE MusicSociety_Master(
Composer_MusicSocietyID CHAR(3),
Composer_MusicSocietyName VARCHAR2(50));

CREATE TABLE Artist_Master
(Artist_id NUMBER(6),
Artist_Name VARCHAR2(50),
Artist_Type char(1),
Artist_BornDate DATE,
Artist_DiedDate DATE,
Created_By NUMBER(6),
Created_On DATE,
Updated_By NUMBER(6),
Updated_On DATE,
Artist_DeletedFlag char(1),
CONSTRAINT Artist_Master_pk PRIMARY KEY(Artist_id));

INSERT INTO User_Master VALUES(155201,'admin',155268,sysdate,155278,sysdate,'A');
INSERT INTO User_Master VALUES(155202,'user',155268,sysdate,155278,sysdate,'U');
INSERT INTO User_Master VALUES(155203,'admin',155268,sysdate,155278,sysdate,'A');
insert into MUSICSOCIETY_MASTER values('100','ABC');
insert into MUSICSOCIETY_MASTER values('101','XYZ');
insert into MUSICSOCIETY_MASTER values('000','Not a part of society yet');


select * from COMPOSER_MASTER;
select * from USER_MASTER;


	
INSERT INTO Composer_Manager values(C_Seq.NEXTVal,'name','12-jan-1995','12-jan-1995','675','878',7657,SYSDATE,87687,SYSDATE,'T');

select * from MusicSociety_Master;

INSERT INTO Composer_Manager values(C_Seq.nextVal,'BAJAJ',TO_DATE('03/12/1995','dd/mm/yyyy'),
NVL2(NULL,TO_DATE(NULL,'dd/mm/yyyy'),NULL)
,'100A','100',68688,SYSDATE,87686,SYSDATE,'F');



select * from artist_master;
SELECT C.Composer_id,C.Composer_Name,C.Composer_BornDate,C.Composer_DiedDate,C.Composer_CaeipiNumber,C.Composer_MusicSocietyID,C.Created_By,C.Created_On,C.Updated_By,C.Updated_On,M.Composer_MusicSocietyName FROM Composer_Master C,MusicSociety_Master M WHERE C.Composer_id=1061 AND M.Composer_MusicSocietyID=C.Composer_MusicSocietyID;






