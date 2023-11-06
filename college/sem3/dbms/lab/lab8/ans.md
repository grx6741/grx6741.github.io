# ICS 213 DATABASE MANAGEMENT SYSTEM

## Gowrish I

## 2022BCS0155

### Table Creations

```sql

CREATE TABLE SAILORS(
    SID INT(5),
    SNAME VARCHAR(30),
    RATING INT(5),
    AGE DECIMAL(4, 2),
    PRIMARY KEY(SID)
);

CREATE TABLE BOATS(
    BID INT(5),
    BNAME VARCHAR(30),
    COLOR VARCHAR(10),
    PRIMARY KEY(BID)
);

CREATE TABLE RESERVES(
    SID INT(5),
    BID INT(5),
    DAY DATE,
    PRIMARY KEY(SID, BID, DAY),
    FOREIGN KEY(SID) REFERENCES SAILORS(SID),
    FOREIGN KEY(BID) REFERENCES BOATS(BID)
);

```

### Insertion of entries

```sql

insert into SAILORS values(22,'dustin',7,45);
insert into SAILORS values(29,'brutus',1,33);
insert into SAILORS values(31,'lubber',79,55);
insert into SAILORS values(32,'andy',8,25);
insert into SAILORS values(58,'rusty',10,35);
insert into SAILORS values(59,'buplb',10,35);
insert into SAILORS values(60,'buplerb',10,35);
insert into SAILORS values(22,'bb',10,35);

insert into BOATS values(101,'interlake','blue');
insert into BOATS values(102,'interlake','red');
insert into BOATS values(103,'clipper','green');
insert into BOATS values(104,'marine','red')

insert into RESERVES values(22,101,'2004-01-01');
insert into RESERVES values(23,102,'2004-01-01');
insert into RESERVES values(24,103,'2004-02-01');
insert into RESERVES values(25,105,'2004-02-01');
insert into RESERVES values(31,103,'2005-05-05');
insert into RESERVES values(32,104,'2005-04-07');
```

### Final Tables Are

> SAILORS

```text
+-----+---------+--------+-------+
| SID | SNAME   | RATING | AGE   |
+-----+---------+--------+-------+
|  22 | dustin  |      7 | 45.00 |
|  29 | brutus  |      1 | 33.00 |
|  31 | lubber  |     79 | 55.00 |
|  32 | andy    |      8 | 25.00 |
|  58 | rusty   |     10 | 35.00 |
|  59 | buplb   |     10 | 35.00 |
|  60 | buplerb |     10 | 35.00 |
+-----+---------+--------+-------+
```

> BOATS

```text
+-----+-----------+-------+
| BID | BNAME     | COLOR |
+-----+-----------+-------+
| 101 | interlake | blue  |
| 102 | interlake | red   |
| 103 | clipper   | green |
| 104 | marine    | red   |
+-----+-----------+-------+
```

> RESERVES

```text
+-----+-----+------------+
| SID | BID | DAY        |
+-----+-----+------------+
|  22 | 101 | 2004-01-01 |
|  22 | 102 | 2004-01-01 |
|  22 | 103 | 2004-02-01 |
|  31 | 103 | 2005-05-05 |
|  32 | 104 | 2005-04-07 |
+-----+-----+------------+
```

### Practice Questions

1. Find sid and names of sailors who have reserved a boat.

```sql
SELECT S.SID, S.SNAME, R.BID
FROM SAILORS S, RESERVES R
WHERE S.SID = R.SID

-- OR 

SELECT S.SID, S.SNAME, R.BID
FROM SAILORS S INNER JOIN RESERVES R ON S.SID = R.SID;

```

```text
+-----+--------+-----+
| SID | SNAME  | BID |
+-----+--------+-----+
|  22 | dustin | 101 |
|  22 | dustin | 102 |
|  22 | dustin | 103 |
|  31 | lubber | 103 |
|  32 | andy   | 104 |
+-----+--------+-----+
```

2. Find all sid & boat information on which ones are reserved.

```sql
SELECT S.SID, S.SNAME, R.BID
FROM SAILORS S LEFT OUTER JOIN RESERVES R ON S.SID = R.SID;
```

```text
+-----+---------+------+
| SID | SNAME   | BID  |
+-----+---------+------+
|  22 | dustin  |  101 |
|  22 | dustin  |  102 |
|  22 | dustin  |  103 |
|  29 | brutus  | NULL |
|  31 | lubber  |  103 |
|  32 | andy    |  104 |
|  58 | rusty   | NULL |
|  59 | buplb   | NULL |
|  60 | buplerb | NULL |
+-----+---------+------+
```

3. Find all sid & boat information on which ones are reserved.

```sql
SELECT S.SID, B.BID, B.BNAME FROM SAILORS S, RESERVES R RIGHT OUTER JOIN BOATS B ON R.BID = B.BID;
```

```text
+-----+-----+-----------+
| SID | BID | BNAME     |
+-----+-----+-----------+
|  22 | 101 | interlake |
|  22 | 102 | interlake |
|  22 | 103 | clipper   |
|  22 | 103 | clipper   |
|  22 | 104 | marine    |
|  29 | 101 | interlake |
|  29 | 102 | interlake |
|  29 | 103 | clipper   |
|  29 | 103 | clipper   |
|  29 | 104 | marine    |
|  31 | 101 | interlake |
|  31 | 102 | interlake |
|  31 | 103 | clipper   |
|  31 | 103 | clipper   |
|  31 | 104 | marine    |
|  32 | 101 | interlake |
|  32 | 102 | interlake |
|  32 | 103 | clipper   |
|  32 | 103 | clipper   |
|  32 | 104 | marine    |
|  58 | 101 | interlake |
|  58 | 102 | interlake |
|  58 | 103 | clipper   |
|  58 | 103 | clipper   |
|  58 | 104 | marine    |
|  59 | 101 | interlake |
|  59 | 102 | interlake |
|  59 | 103 | clipper   |
|  59 | 103 | clipper   |
|  59 | 104 | marine    |
|  60 | 101 | interlake |
|  60 | 102 | interlake |
|  60 | 103 | clipper   |
|  60 | 103 | clipper   |
|  60 | 104 | marine    |
+-----+-----+-----------+
```

4. Find all boats & all information on reservations.

```sql
SELECT S.SID, S.SNAME, B.BID, B.BNAME
FROM SAILORS S
INNER JOIN RESERVES R ON S.SID = R.SID
INNER JOIN BOATS B ON R.BID = B.BID;
```

```text
+-----+--------+-----+-----------+
| SID | SNAME  | BID | BNAME     |
+-----+--------+-----+-----------+
|  22 | dustin | 101 | interlake |
|  22 | dustin | 102 | interlake |
|  22 | dustin | 103 | clipper   |
|  31 | lubber | 103 | clipper   |
|  32 | andy   | 104 | marine    |
+-----+--------+-----+-----------+
```

### Questions

1. Write an sql query to make one of the fields of a table as primary key.

```sql
ALTER TABLE SAILORS
ADD PRIMARY KEY (your_field_name);
```

2. Write an sql query to make one of the fields of a table as foreign key.

```sql
ALTER TABLE BOATS 
ADD CONSTRAINT MY_CONSTRAINT
FOREIGN KEY (BID) REFERENCES RESERVES(BID);
```

3. Write an sql query to delete the primary key of a table.

```sql
ALTER TABLE SAILORS
DROP PRIMARY KEY;
```

4. Write an sql query to delete the foreign key of a table

```sql
ALTER TABLE SAILORS
DROP FOREIGN KEY MY_CONSTRAINT;
```

5. 

```sql
ALTER TABLE SAILORS
ADD CONSTRAINT MY_CONSTRAINT
FOREIGN KEY (SID) REFERENCES RESERVES(SID)
ON DELETE CASCADE;
```

6. Write an sql query to add a foreign key with set default on delete.

```sql
ALTER TABLE SAILORS
ADD CONSTRAINT MY_CONSTRAINT
FOREIGN KEY (SID) REFERENCES RESERVES(SID)
ON DELETE SET DEFAULT;
```

7. Write an sql query to add a foreign key with set null on delete.

```sql
ALTER TABLE SAILORS
ADD CONSTRAINT MY_CONSTRAINT
FOREIGN KEY (SID) REFERENCES RESERVES(SID)
ON DELETE SET NULL;
```
