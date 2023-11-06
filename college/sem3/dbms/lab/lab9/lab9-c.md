# ICS 213 DBMS

## Lab 9 - c → Gowrish I (2022BCS0155)

### Problems

> 1. Create a procedure to give a raise to all employees by 10,000 where the employee salary is not null

```sql
CREATE TABLE EMPLOYEESS (
    ID INT PRIMARY KEY, 
    NAME VARCHAR(20) ,
    SUPERID INT , 
    BDATE DATE , 
    SALARY DECIMAL(7,2), 
    DNO INT
);

INSERT INTO EMPLOYEESS ( ID,NAME , SUPERID , SALARY, BDATE, DNO) 
VALUES  (1,'JOHN',3,1000-0, "1960-01-01",1),
        (2, 'MARY',3, 50000,"1964-12-01",3),
        (3, 'BOB', NULL , 80000,"1974-02-07",3),
        (4,'TOM',1,50000,"1978-01-17",2),
        (5, 'BILL' , NULL,NULL ,"1985-01-20",1),
        (6,"LUCY",NULL,90000,"1981-01-01",1),
        (7,"GEORGE",NULL,45000,"1971-11-11",NULL);

SELECT * FROM EMPLOYEESS;
```

```
+----+--------+---------+------------+----------+------+
| ID | NAME   | SUPERID | BDATE      | SALARY   | DNO  |
+----+--------+---------+------------+----------+------+
|  1 | JOHN   |       3 | 1960-01-01 |  1000.00 |    1 |
|  2 | MARY   |       3 | 1964-12-01 | 50000.00 |    3 |
|  3 | BOB    |    NULL | 1974-02-07 | 80000.00 |    3 |
|  4 | TOM    |       1 | 1978-01-17 | 50000.00 |    2 |
|  5 | BILL   |    NULL | 1985-01-20 |     NULL |    1 |
|  6 | LUCY   |    NULL | 1981-01-01 | 90000.00 |    1 |
|  7 | GEORGE |    NULL | 1971-11-11 | 45000.00 | NULL |
+----+--------+---------+------------+----------+------+
```

```sql
DELIMITER //

CREATE PROCEDURE SALL()
    BEGIN
        DECLARE EMP_ID INT DEFAULT 0;
        DECLARE EMP_SAL DECIMAL(10,2) DEFAULT 0.00;
        DECLARE CURSOR_I CURSOR FOR SELECT ID, SALARY FROM EMPLOYEESS;
        OPEN CURSOR_I;
        FETCH CURSOR_I INTO EMP_ID, EMP_SAL;
        UPDATE EMPLOYEESS SET SALARY = SALARY + 10000 WHERE EMP_SAL IS NOT NULL;
        CLOSE CURSOR_I;
    END //
DELIMITER ;
CALL SALL();

SELECT * FROM EMPLOYEESS;
```

> 2. Create a stored procedure to update the total salary of a department by 90,000 when a new employee is hired in the department. The employee salary should be updated if its old value is not null

```sql

CREATE TABLE EMPLOYEES(
    ID INT PRIMARY KEY,
    NAME VARCHAR(10),
    SUPERID INT,
    SALARY INT,
    BDATE DATE,
    DNO INT
);

INSERT INTO EMPLOYEES VALUES(1,"JOHN",3,100000,"1960-01-01",1);
INSERT INTO EMPLOYEES VALUES(2,"MARY",3,50000,"1964-12-01",3);
INSERT INTO EMPLOYEES VALUES(3,"BOB",NULL,80000,"1974-02-07",3);
INSERT INTO EMPLOYEES VALUES(4,"TOM",1,50000,"1970-01-17",2);
INSERT INTO EMPLOYEES VALUES(5,"BILL",NULL,NULL,"1985-01-20",1);

SELECT * FROM EMPLOYEES;

DELIMITER //
CREATE PROCEDURE UpdateDepartmentSalary()
    BEGIN
    DECLARE salary_increase DECIMAL(10, 2);
    DECLARE counti INT;

    SELECT COUNT(*) INTO counti 
    FROM EMPLOYEES 
    WHERE SALARY IS NOT NULL;

    SET salary_increase = 90000/counti;

    UPDATE EMPLOYEES
    SET SALARY = SALARY + salary_increase
    WHERE SALARY IS NOT NULL;

    END;
//
DELIMITER ;
CALL UpdateDepartmentSalary();
SELECT * FROM EMPLOYEES;
```

```text
+----+------+---------+--------+------------+------+
| ID | NAME | SUPERID | SALARY | BDATE      | DNO  |
+----+------+---------+--------+------------+------+
|  1 | JOHN |       3 | 100000 | 1960-01-01 |    1 |
|  2 | MARY |       3 |  50000 | 1964-12-01 |    3 |
|  3 | BOB  |    NULL |  80000 | 1974-02-07 |    3 |
|  4 | TOM  |       1 |  50000 | 1970-01-17 |    2 |
|  5 | BILL |    NULL |   NULL | 1985-01-20 |    1 |
+----+------+---------+--------+------------+------+
5 rows in set (0.000 sec)

+----+------+---------+--------+------------+------+
| ID | NAME | SUPERID | SALARY | BDATE      | DNO  |
+----+------+---------+--------+------------+------+
|  1 | JOHN |       3 | 122500 | 1960-01-01 |    1 |
|  2 | MARY |       3 |  72500 | 1964-12-01 |    3 |
|  3 | BOB  |    NULL | 102500 | 1974-02-07 |    3 |
|  4 | TOM  |       1 |  72500 | 1970-01-17 |    2 |
|  5 | BILL |    NULL |   NULL | 1985-01-20 |    1 |
+----+------+---------+--------+------------+------+
5 rows in set (0.000 sec)
```

> 3. Create a table student_marks with 10 columns (Student_id, Name, Sub1, Sub2, Sub3, Sub4, Sub5, Total, Perc, and Grade). Initially, the student_marks table should contain 4 rows and there should be data only in STUDENT_ID and NAME columns. Create a stored procedure to calculate Total, Perc, and Grade and update student_marks table whenever the subject marks are entered. The criterion for calculating Total, Perc, and Grade is given below:  Total Marks (will be stored in TOTAL column) : TOTAL = SUB1 + SUB2 + SUB3 + SUB4 + SUB5  Percentage of Marks (will be stored in PER_MARKS column) : PER_MARKS = (TOTAL)/5  Grade (will be stored GRADE column) : If PER_MARKS >= 90 -> 'EXCELLENT' If PER_MARKS >= 75 AND PER_MARKS < 90 -> 'VERY GOOD' If PER_MARKS >= 60 AND PER_MARKS < 75 -> 'GOOD' If PER_MARKS >= 40 AND PER_MARKS < 60 -> 'AVERAGE' If PER_MARKS <40 -> 'NOT PROMOTED

```sql
-- Creation of student_marks
create table student_marks (
    Student_id int primary key, 
    Name varchar(50), 
    Sub1 int, 
    Sub2 int, 
    Sub3 int, 
    Sub4 int,
    Sub5 int, 
    Total int, 
    Perc decimal(5, 2), 
    Grade varchar(50)
);

-- Insertion of Initial Values

INSERT INTO student_marks VALUES(1,"gowrish",20,30,40,50,60,null,null,null);
INSERT INTO student_marks VALUES(2,"lokesh",10,10,10,10,10,null,null,null);
INSERT INTO student_marks VALUES(3,"sai",30,90,40,67,43,null,null,null);
INSERT INTO student_marks VALUES(4,"govind",66,89,92,100,98,null,null,null);

```

```
+------------+---------+------+------+------+------+------+-------+------+-------+
| Student_id | Name    | Sub1 | Sub2 | Sub3 | Sub4 | Sub5 | Total | Perc | Grade |
+------------+---------+------+------+------+------+------+-------+------+-------+
|          1 | gowrish | NULL | NULL | NULL | NULL | NULL |  NULL | NULL | NULL  |
|          2 | lokesh  | NULL | NULL | NULL | NULL | NULL |  NULL | NULL | NULL  |
|          3 | govind  | NULL | NULL | NULL | NULL | NULL |  NULL | NULL | NULL  |
|          4 | sai     | NULL | NULL | NULL | NULL | NULL |  NULL | NULL | NULL  |
+------------+---------+------+------+------+------+------+-------+------+-------+
```

```sql
DELIMITER //
CREATE PROCEDURE CalculateStudentMarks()
    BEGIN
        UPDATE student_marks AS sm
        SET sm.Total = sm.Sub1 + sm.Sub2 + sm.Sub3 + sm.Sub4 + sm.Sub5,
        sm.Perc = (sm.Sub1 + sm.Sub2 + sm.Sub3 + sm.Sub4 + sm.Sub5) / 5,
        sm.Grade = CASE
        WHEN (sm.Sub1 + sm.Sub2 + sm.Sub3 + sm.Sub4 + sm.Sub5) / 5 >= 90 THEN
        'EXCELLENT'
        WHEN (sm.Sub1 + sm.Sub2 + sm.Sub3 + sm.Sub4 + sm.Sub5) / 5 >= 75 THEN
        'VERY GOOD'
        WHEN (sm.Sub1 + sm.Sub2 + sm.Sub3 + sm.Sub4 + sm.Sub5) / 5 >= 60 THEN
        'GOOD'
        WHEN (sm.Sub1 + sm.Sub2 + sm.Sub3 + sm.Sub4 + sm.Sub5) / 5 >= 40 THEN
        'AVERAGE'
        ELSE 'NOT PROMOTED'
        END
        WHERE sm.Total IS NULL;
    END;
//
DELIMITER ;
CALL CalculateStudentMarks();
SELECT * FROM student_marks;
```

```
+------------+---------+------+------+------+------+------+-------+-------+--------------+
| Student_id | Name    | Sub1 | Sub2 | Sub3 | Sub4 | Sub5 | Total | Perc  | Grade        |
+------------+---------+------+------+------+------+------+-------+-------+--------------+
|          1 | gowrish |   20 |   30 |   40 |   50 |   60 |   200 | 40.00 | AVERAGE      |
|          2 | lokesh  |   10 |   10 |   10 |   10 |   10 |    50 | 10.00 | NOT PROMOTED |
|          3 | sai     |   30 |   90 |   40 |   67 |   43 |   270 | 54.00 | AVERAGE      |
|          4 | govind  |   66 |   89 |   92 |  100 |   98 |   445 | 89.00 | VERY GOOD    |
+------------+---------+------+------+------+------+------+-------+-------+--------------+
```

> 4. Write a stored procedure "USER_LOGINS" to create login id for user based on user first name and institute name in "USERS" table. The pattern of the login id should be "@.in". The details of the fields are as given below
>
> - USER_ID (integer type)
> - FIRST_NAME (character data type of length 20)
> - INST_NAME (character data type of length 20)
> - LOGIN_ID (character data type of length 50)

```sql

CREATE TABLE INSTIT (
    USER_ID INT,
    FIRST_NAME VARCHAR(20),
    INST_NAME VARCHAR(20),
    LOGIN_ID VARCHAR(50)
);

INSERT INTO INSTIT(USER_ID,FIRST_NAME,INST_NAME) 
VALUES
    (201,"gowrish","IIITK"),
    (202,"lokesh","IIITK"),
    (203,"sai","IIITK"),
    (204,"varun","IITM"),
    (205,"govind","IITB");

SELECT * FROM INSTIT;
```

```
+---------+------------+-----------+----------+
| USER_ID | FIRST_NAME | INST_NAME | LOGIN_ID |
+---------+------------+-----------+----------+
|     201 | gowrish    | IIITK     | NULL     |
|     202 | lokesh     | IIITK     | NULL     |
|     203 | sai        | IIITK     | NULL     |
|     204 | varun      | IITM      | NULL     |
|     205 | govind     | IITB      | NULL     |
+---------+------------+-----------+----------+
```

```sql
DELIMITER //
CREATE PROCEDURE MAKE_LOGIN()
    BEGIN
        UPDATE INSTIT AS ii SET
        LOGIN_ID = CONCAT(ii.FIRST_NAME,'@',ii.INST_NAME,'.ac.in');
    END //
DELIMITER ;

CALL MAKE_LOGIN();

SELECT * FROM INSTIT;
```

```
+---------+------------+-----------+---------------------+
| USER_ID | FIRST_NAME | INST_NAME | LOGIN_ID            |
+---------+------------+-----------+---------------------+
|     201 | gowrish    | IIITK     | gowrish@IIITK.ac.in |
|     202 | lokesh     | IIITK     | lokesh@IIITK.ac.in  |
|     203 | sai        | IIITK     | sai@IIITK.ac.in     |
|     204 | varun      | IITM      | varun@IITM.ac.in    |
|     205 | govind     | IITB      | govind@IITB.ac.in   |
+---------+------------+-----------+---------------------+
```
