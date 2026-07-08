# Expense Tracking System

## Overview

The Expense Tracking System is a Java Swing desktop application developed using Object-Oriented Programming (OOP) principles. It allows users to manage their daily expenses, monitor their monthly budget, search expenses, and maintain records using a text file for permanent storage.

---

## Features

* User Login

  * Username: **admin**
  * Password: **1234**

* Dashboard

* Add Expense

* View Expenses

* Search Expenses by Category

* Delete Expenses

* Budget Summary

* Budget Warning when the budget is exceeded

* Automatic Expense ID Generation

* Save Expenses to a Text File

* Load Saved Expenses Automatically

---

## Technologies Used

* Java
* Java Swing
* ArrayList Collections
* File Handling
* Exception Handling
* Event Handling

---

## Object-Oriented Programming Concepts

### Encapsulation

Implemented in:

* Expense.java
* Budget.java

### Inheritance

Implemented in:

* RecurringExpense.java extends Expense.java

### Polymorphism

Implemented by overriding the `toString()` method in `RecurringExpense.java`.

### Abstraction

Achieved through the separation of responsibilities among different classes.

---

## Project Structure

```text
src/
│
├── Main.java
├── LoginFrame.java
├── DashboardFrame.java
├── Expense.java
├── ExpenseManager.java
├── ExpenseFileManager.java
├── Budget.java
├── AddExpenseFrame.java
├── ViewExpenseFrame.java
├── BudgetSummaryFrame.java
├── RecurringExpense.java
└── User.java
```

---

## How to Run

1. Compile the project.

2. Run `Main.java`.

3. Login using:

* Username: **admin**
* Password: **1234**

4. Start managing expenses.

---

## Screenshots

Add screenshots of:

* Login Screen
* Dashboard
* Add Expense
* View Expenses
* Budget Summary

---

## Author

Daniel Kingsford Krah | MS/ITE/25/0011  | HOLY CHILD (TAKORADI)
