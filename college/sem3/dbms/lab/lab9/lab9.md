# ICS 213 DBMS

## Gowrish I 2022BCS0155

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

### Write trigger to prevent reservation of boat 103

```sql
DELIMITER //

CREATE TRIGGER prevent_reservation_boat_103
BEFORE INSERT ON reserves
FOR EACH ROW
BEGIN
    IF NEW.bid = 103 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "Can't create reservation for Boat 103";
    END IF;
END; //

DELIMITER ;
```

### Write trigger to prevent reservation of boats, if the total number of boats less than 5.

```sql
DELIMITER //

CREATE TRIGGER prevent_reservation_boat_less_than_5
BEFORE INSERT ON reserves
FOR EACH ROW
BEGIN
    IF (SELECT COUNT(*) FROM BOATS) < 5 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "Can't create reservation when number of boats is less than 5";
    END IF;
END; //

DELIMITER ;
```

### Write trigger to prevent reservation of red boats

```sql
DELIMITER //

CREATE TRIGGER prevent_reservation_red_boat
BEFORE INSERT ON reserves
FOR EACH ROW
BEGIN
	DECLARE boat_color VARCHAR(50);
    SELECT color INTO boat_color
    FROM boats
    WHERE bid = NEW.bid;
	IF (boat_color = 'red') THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Can't create reservation for read boat";
	END IF;
END; //

DELIMITER ;
```

### Write trigger(s) to count number of operations (INSERT/UPDATE/DELETE) performed on tables SAILORS, BOATS and RESERVES.

```sql
DELIMITER //

CREATE TRIGGER CountSailorsOperations
AFTER INSERT, UPDATE, DELETE ON SAILORS
FOR EACH STATEMENT
BEGIN
  DECLARE numOperations INT;
  SET numOperations = ROW_COUNT();
  
  -- You can use the numOperations variable as needed, e.g., log it or store it in a dedicated table.
END;
//

DELIMITER ;
```

### Write trigger for each new sailor, by default boats id 101 is reserved on ‘2023-01-01’

```sql
DELIMITER $
CREATE TRIGGER DefaultReservationForNewSailor
AFTER INSERT ON Sailors
FOR EACH ROW
BEGIN
  INSERT INTO reserves (sid, bid, day)
  VALUES (NEW.sid, 101, '2023-01-01');
END;$
DELIMITER ;
```
