# ICS 213 DBMS

## LAB 9 - B

## Gowrish I 2022BCS0155

### Database and Tables

```sql
create database lab9;
use lab9;

CREATE TABLE STUDENT_DETAILS(
    STUD_ID INT PRIMARY KEY,
    NAME VARCHAR(10),
    ADDRESS VARCHAR(10)
);

INSERT INTO STUDENT_DETAILS VALUES(1,"Stephan","Delhi");
INSERT INTO STUDENT_DETAILS VALUES(2,"Kathrin","Noida");
INSERT INTO STUDENT_DETAILS VALUES(3,"David","Ghaziabad");
INSERT INTO STUDENT_DETAILS VALUES(4,"Alina","Gurugram");
INSERT INTO STUDENT_DETAILS VALUES(5,"John","Kerala");

CREATE TABLE STUDENTS_MARKS( 
    STU_ID INT PRIMARY KEY,
    NAME VARCHAR(10),
    MARKS INT,
    AGE INT
);

INSERT INTO STUDENTS_MARKS VALUES(1,"Stephan",97,19);
INSERT INTO STUDENTS_MARKS VALUES(2,"Katharin",86,21);
INSERT INTO STUDENTS_MARKS VALUES(3,"David",74,18);
INSERT INTO STUDENTS_MARKS VALUES(4,"Alina",90,20);
INSERT INTO STUDENTS_MARKS VALUES(5,"John",96,18);

SELECT * FROM STUDENTS_MARKS;
```

- STUDENT_DETAILS

```text
+---------+---------+-----------+
| STUD_ID | NAME    | ADDRESS   |
+---------+---------+-----------+
|       1 | Stephan | Delhi     |
|       2 | Kathrin | Noida     |
|       3 | David   | Ghaziabad |
|       4 | Alina   | Gurugram  |
|       5 | John    | Kerala    |
+---------+---------+-----------+
```

- STUDENTS_MARKS

```text
+--------+----------+-------+------+
| STU_ID | NAME     | MARKS | AGE  |
+--------+----------+-------+------+
|      1 | Stephan  |    97 |   19 |
|      2 | Katharin |    86 |   21 |
|      3 | David    |    74 |   18 |
|      4 | Alina    |    90 |   20 |
|      5 | John     |    96 |   18 |
+--------+----------+-------+------+
```

#### Problems

- Create a queries to GRANT INSERT, DELETE ON Student Details TO Alina WITH GRANT OPTIONS

```sql
CREATE USER Alina IDENTIFIED BY 'Alina';
GRANT INSERT, DELETE ON STUDENT_DETAILS TO Alina WITH GRANT OPTION;
```

```text
Query OK, 0 rows affected (0.008 sec)
```

- Create a quires GRANT UPDATE (MARKS) ON Student Marks TO David

```sql
CREATE USER David IDENTIFIED BY 'David';
GRANT UPDATE (MARKS) ON Students_Marks TO 'David';
```

```text
Query OK, 0 rows affected (0.008 sec)
```

- Create a View named Details View from the table Student Detail and display the details whose STU_ID >3.

```sql
CREATE VIEW DetailsView 
AS SELECT * 
    FROM STUDENT_DETAILS 
    WHERE STUD_ID>3;

SELECT * FROM DetailsView;
```

```text
+---------+-------+----------+
| STUD_ID | NAME  | ADDRESS  |
+---------+-------+----------+
|       4 | Alina | Gurugram |
|       5 | John  | Kerala   |
+---------+-------+----------+
```

- Create a view named Marks View from two tables Student Detail and Student Marks (Creating View from multiple tables).

```sql
CREATE VIEW MarksView AS 
    SELECT STUD_ID,SD.NAME,ADDRESS,MARKS 
    FROM STUDENT_DETAILS SD,STUDENTS_MARKS SM 
    WHERE 
        SD.STUD_ID=SM.STU_ID;

SELECT * FROM MarksView;
```

```text
+---------+---------+-----------+-------+
| STUD_ID | NAME    | ADDRESS   | MARKS |
+---------+---------+-----------+-------+
|       1 | Stephan | Delhi     |    97 |
|       2 | Kathrin | Noida     |    86 |
|       3 | David   | Ghaziabad |    74 |
|       4 | Alina   | Gurugram  |    90 |
|       5 | John    | Kerala    |    96 |
+---------+---------+-----------+-------+
```

- Delete the View MarksView.

```sql
drop view MarksView;
```

```text
Query OK, 0 rows affected (0.008 sec)
```

- Delete the View DetailsView.

```sql
drop view DetailsView;
```

```text
Query OK, 0 rows affected (0.008 sec)
```

- Create a view Student_John from the table Student Marks he should see only his record

```sql
CREATE USER John IDENTIFIED BY 'John';

CREATE VIEW Student_John AS SELECT * FROM STUDENTS_MARKS WHERE NAME="John" ;

GRANT SELECT ON DetailsView TO 'John';

ALTER USER 'John';

SELECT * FROM Student_John;
```

```text
+--------+------+-------+------+
| STU_ID | NAME | MARKS | AGE  |
+--------+------+-------+------+
|      5 | John |    96 |   18 |
+--------+------+-------+------+
```
