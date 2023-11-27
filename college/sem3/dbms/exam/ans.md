# LAB EXAM

## Gowrish I 2022BCS0155

```sql
create table students (
	rollno varchar(5) primary key,
    sname varchar(20),
    dob DATE,
    branch varchar(50),
    gender char(1),
    percentage decimal(3, 2) default 0.00create table students (
	rollno varchar(5) primary key,
    sname varchar(20),
    dob DATE,
    branch varchar(50),
    gender char(1),
    percentage decimal(3, 2) default 0.00
);

create table subjects (
	scode int primary key,
    subname varchar(20),
    branch varchar(2),
    passmark int,
    credits int
);

create table marks (
	rollno varchar(5),
    scode int,
    score int,
    status varchar(1)
);

);

create table subjects (
insert into subjects values
	(101, 'DBMS', 'CS', 60, 3),
	(102, 'OS', 'CS', 65, 3);
	scode int primary key,
    subname varchar(20),
    branch varchar(2),
    passmark int,
    credits int
);

create table marks (
	rollno varchar(5),
    scode int,
    score int,
    status varchar(1)
);

insert into students values
	('CS001', 'lokesh', '2004-01-10', 'CS', 'M', 0.00),
    ('CS002', 'rakesh', '2004-05-01', 'CS', 'M', 0.00);

insert into subjects values
	(101, 'DBMS', 'CS', 60, 3),
	(102, 'OS', 'CS', 65, 3);

insert into marks values
    ('CS001', 101, 45, ''),
    ('CS002', 101, 62, '');

```

# 1

```sql
select count(m.rollno)
from marks m, subjects s, students st
where
	m.scode = s.scode and st.rollno = m.rollno and st.gender = 'M' and m.score >= s.passmark;
```

# 2

```sql
alter table marks
add constraint marks_cannot_be_neg
check (score > 0);
```

# 3

```sql
delimiter //

create trigger count_student_insert
after insert on students
for each row 
begin
select count(*) from students;
end //

create trigger count_student_delete
after delete on students
for each row 
begin
select count(*) from students;
end //

delimiter ;
```
