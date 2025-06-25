CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 



INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Exercise 6

-- Scenario 1

SET SERVEROUTPUT ON;

DECLARE
  CURSOR txn_cursor IS
    SELECT c.Name, t.AccountID, t.Amount, t.TransactionType, t.TransactionDate
    FROM Transactions t
    JOIN Accounts a ON t.AccountID = a.AccountID
    JOIN Customers c ON a.CustomerID = c.CustomerID
    WHERE TO_CHAR(t.TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY')
    ORDER BY c.Name;

  rec txn_cursor%ROWTYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Monthly Transaction Statements ---');

  OPEN txn_cursor;
  LOOP
    FETCH txn_cursor INTO rec;
    EXIT WHEN txn_cursor%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || 
                         ' | Account: ' || rec.AccountID || 
                         ' | ' || rec.TransactionType || 
                         ' $' || rec.Amount || 
                         ' on ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY'));
  END LOOP;

  CLOSE txn_cursor;
END;
/

-- Scenario 2

SET SERVEROUTPUT ON;

DECLARE
  v_fee NUMBER := 100;
  CURSOR acc_cursor IS
    SELECT AccountID, Balance FROM Accounts;

  acc_rec acc_cursor%ROWTYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Applying Annual Fee of $' || v_fee || ' to All Accounts ---');

  OPEN acc_cursor;
  LOOP
    FETCH acc_cursor INTO acc_rec;
    EXIT WHEN acc_cursor%NOTFOUND;

    IF acc_rec.Balance >= v_fee THEN
      UPDATE Accounts
      SET Balance = Balance - v_fee,
          LastModified = SYSDATE
      WHERE AccountID = acc_rec.AccountID;

      DBMS_OUTPUT.PUT_LINE('Fee applied to Account ID: ' || acc_rec.AccountID);
    ELSE
      DBMS_OUTPUT.PUT_LINE('Skipping Account ID: ' || acc_rec.AccountID || ' due to low balance.');
    END IF;
  END LOOP;

  CLOSE acc_cursor;
  COMMIT;
END;
/



-- Scenario 3

SET SERVEROUTPUT ON;

DECLARE
  CURSOR loan_cursor IS
    SELECT LoanID, LoanAmount, InterestRate FROM Loans;

  loan_rec loan_cursor%ROWTYPE;
  v_increment NUMBER;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Updating Loan Interest Rates Based on New Policy ---');

  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO loan_rec;
    EXIT WHEN loan_cursor%NOTFOUND;

    IF loan_rec.LoanAmount >= 5000 THEN
      v_increment := 0.5;
    ELSE
      v_increment := 1.0;
    END IF;

    UPDATE Loans
    SET InterestRate = InterestRate + v_increment
    WHERE LoanID = loan_rec.LoanID;

    DBMS_OUTPUT.PUT_LINE('Loan ID ' || loan_rec.LoanID || 
                         ' updated. New rate: ' || (loan_rec.InterestRate + v_increment));
  END LOOP;

  CLOSE loan_cursor;
  COMMIT;
END;
/





