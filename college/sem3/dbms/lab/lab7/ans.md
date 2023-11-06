# Gowrish I 2022BCS0155

## LAB 7

### Tables

```sql
CREATE TABLE sailors (
    sid INT PRIMARY KEY,
    sname VARCHAR(50),
    age INT,
    rating INT
);

CREATE TABLE boats (
    bid INT PRIMARY KEY,
    bname VARCHAR(50),
    color VARCHAR(50)
);

CREATE TABLE reserves (
    sid INT,
    bid INT,
    day DATE,
    PRIMARY KEY (sid, bid, day),
    FOREIGN KEY (sid) REFERENCES sailors(sid),
    FOREIGN KEY (bid) REFERENCES boats(bid)
);

```

### Write a triger(s) to count number of red boats

```sql
DELIMITER //

-- Trigger when a boat is added
CREATE TRIGGER red_boat_count_trigger
AFTER INSERT ON boats
FOR EACH ROW
BEGIN
    IF NEW.color = 'red' THEN
        SET @red_boat_count = @red_boat_count + 1;
    END IF;
END;
//

-- Trigger when a boat is updated
CREATE TRIGGER red_boat_count_update_trigger
AFTER UPDATE ON boats
FOR EACH ROW
BEGIN
    IF NEW.color = 'red' AND OLD.color != 'red' THEN
        SET @red_boat_count = @red_boat_count + 1;
    ELSEIF NEW.color != 'red' AND OLD.color = 'red' THEN
        SET @red_boat_count = @red_boat_count - 1;
    END IF;
END;
//

-- Trigger when a boat is deleted
CREATE TRIGGER red_boat_count_delete_trigger
AFTER DELETE ON boats
FOR EACH ROW
BEGIN
    IF OLD.color = 'red' THEN
        SET @red_boat_count = @red_boat_count - 1;
    END IF;
END;

SET @red_boat_count = 0;

//

DELIMITER ;
```

### Write a triger(s) to count number of expert sailors, if rating > 7

```sql
DELIMITER //

-- trigger when a sailor is inserted
CREATE TRIGGER expert_sailor_count_trigger
AFTER INSERT ON sailors
FOR EACH ROW
BEGIN
    IF NEW.rating > 7 THEN
        SET @expert_sailor_count = @expert_sailor_count + 1;
    END IF;
END;
//

-- trigger when a sailor is updated
CREATE TRIGGER expert_sailor_count_update_trigger
AFTER UPDATE ON sailors
FOR EACH ROW
BEGIN
    IF NEW.rating > 7 AND OLD.rating <= 7 THEN
        SET @expert_sailor_count = @expert_sailor_count + 1;
    ELSEIF NEW.rating <= 7 AND OLD.rating > 7 THEN
        SET @expert_sailor_count = @expert_sailor_count - 1;
    END IF;
END;
//

DELIMITER ;
```

### Write a trigger(s) to prevent minor sailors, if age<18 being inserted in to table. (Hint: Use SIGNAL SQLSTATE)

```sql
DELIMITER //

-- trigger when a sailor is inserted
CREATE TRIGGER minor_sailor_insert_trigger
AFTER INSERT ON sailors
FOR EACH ROW
BEGIN
    IF NEW.age < 18 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'age less than 18';
    END IF;
END;
//
```
