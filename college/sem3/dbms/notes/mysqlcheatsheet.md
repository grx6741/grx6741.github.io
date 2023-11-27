# MYSQL

```sql
create database mydb; -- create database
use mydb; -- use database
drop database mydb; -- delete database
alter database mydb read only = 1; -- set to read only

alter table mytable add column_name data_type;
alter table mytable rename column c1 to c2;
alter table mytable modify column c1 data_type; -- change datatype
alter table mytable modify column c1 datatype after c2; -- change pos of c1 after c2
alter table mytable modify column c1 datatype first; -- change pos of c1 to beginning

update table_name set c1 = <c1> where condition;
delete from table_name where condition;

create view viewname as select c1, c2 from mytable;
```
