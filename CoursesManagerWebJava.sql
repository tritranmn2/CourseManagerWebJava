
-- CREATE DATABASE COURSES_MANAGER_WEBJAVA ;
DROP TABLE IF EXISTS REGISTER;
DROP TABLE IF EXISTS STUDENTS;
DROP TABLE IF EXISTS COURSES;

-- DROP DATABASE  IF EXISTS COURSES_MANAGER_WEBJAVA;

CREATE TABLE STUDENTS(
	ID VARCHAR(10),
	NAME VARCHAR(20),
	GRADE VARCHAR(10),
	BIRTHDAY VARCHAR(20),
	ADDRESS VARCHAR(20),
	NOTE VARCHAR(20),
	PRIMARY KEY (ID)
);

CREATE TABLE COURSES(
	ID VARCHAR(10),
	NAME VARCHAR(20),
	LECTURE VARCHAR(10),
	YEAR VARCHAR(10),
	NOTE VARCHAR(20),
	PRIMARY KEY (ID,YEAR)
);

CREATE TABLE REGISTER(
	IDHS VARCHAR(10),
	IDCOURSE VARCHAR(10),
	YEAR VARCHAR(10),
	SCORE VARCHAR(10),
	PRIMARY KEY (IDHS,IDCOURSE,YEAR)
);
ALTER TABLE REGISTER ADD FOREIGN KEY (IDHS) REFERENCES STUDENTS(ID);
ALTER TABLE REGISTER ADD FOREIGN KEY (IDCOURSE,YEAR) REFERENCES COURSES(ID,YEAR);

delete from REGISTER;
delete from students;
delete from COURSES;


INSERT INTO STUDENTS(id,name) VALUES(1,'Tran Minh Tri'),
(2,'Nguyen Van Hao'),(3,'Doc Co Cau Bai'),(4,'Duong Qua'),(5,'Long Cong Tu');

insert into COURSES(id,name,year) values(1,'Toan','2000'),
(1,'Toan','2001'),(1,'Toan','2002'),(1,'Toan','2003'),
(2,'Hoa','2020'),(2,'Hoa','2021'),(2,'Hoa','2022'),
(3,'Sinh','2022'),(4,'Dia',2023);


insert into REGISTER(idhs,idcourse,year,score) values(1,1,'2000',8),
(1,1,'2001','10'),(1,1,'2002','9.5'),(1,1,'2003','5.0'),
(2,1,'2000',9),(2,1,'2001','9.5'),(2,2,'2020',9),(2,3,'2022',9);

-- SELECT * FROM STUDENTS;
-- SELECT * FROM COURSES;
-- select * from REGISTER;
-- select idhs,name from REGISTER r join STUDENTS st on r.idhs=st.id 
-- where idcourse ='1' and year='2000';
-- select idcourse,name,c.year, score from REGISTER r join COURSES c on 
-- r.idcourse=c.id  and r.year= c.year
-- where idhs='1' and r.year ='2000';
-- select * from courses where name like '%toan%';