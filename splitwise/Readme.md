# Splitwise - Machine Coding Round

## 🎯 Objective
Design and implement a console-based **expense sharing system** (similar to Splitwise) that allows users to add expenses, split them in different ways, and track balances between users.

The solution should be **functional, compilable, and runnable** within **90–120 minutes** during an interview.

---

## ✅ Functional Requirements

### 1. User Management
- Each user has:
    - **id** (unique)
    - **name**
    - **email/phone** (optional, for uniqueness)
- Ability to **add users** into the system.

---

### 2. Expense Management
- Add an **expense** with the following details:
    - Paid by: a single user (payer).
    - Amount: total expense amount.
    - Participants: list of users who share the expense.
    - Split type:
        1. **EQUAL** → amount split equally among participants.
        2. **EXACT** → exact amounts specified for each participant.
        3. **PERCENT** → percentage distribution specified for each participant.

---

### 3. Balance Tracking
- System must maintain who owes whom and how much.
- Balances should not double-count (if A owes B, then B should not redundantly store the same debt).

---

### 4. Display Balances
- `SHOW` → show balances for all users.
- `SHOW <user_id>` → show balances for a specific user.
- If no balances exist, print:  



---

## ⚙️ Non-Functional Requirements
- Clean **object-oriented design** (classes like `User`, `Expense`, `Split`, `BalanceSheet`, `Service`, `Driver`).
- Code should be **readable, modular, and maintainable**.
- No database required → use **in-memory data structures** (collections/maps).
- Input/Output via **console commands**.
- Handle basic invalid inputs gracefully.

---

## 🚀 Stretch Goals (Optional, if time permits)
- Debt simplification → minimize transactions (e.g., netting off cycles).
- Support **multiple payers** in a single expense.
- Persistence → save/load data from file.
- Better error handling and validations.

---

## 🕐 Suggested Time Plan (90–120 mins)
- **10 mins** → Clarify requirements + sketch class design.
- **50–60 mins** → Implement core features (user mgmt, expenses, balance calc).
- **20–30 mins** → Implement `SHOW` commands + test with sample input/output.
- **10–20 mins** → Stretch goals (if time remains).

---

## 📖 Sample Input / Output

### Input
- ADD_USER
- Tapan tapan.goyal@db.com
- ADD_USER
- Naman naman.g
- ADD_USER
- Ramesh ram.g
- ADD_USER
- Suresh suresh.g
- ADD_EXPENSE
- 1001 99 Sutta 3 EQUAL
- 1001 1002 1003
- SHOW_DEBT
- 0
- ADD_EXPENSE
- 1002 200 Sutta 3 PERCENT
- 1001 50
- 1002 25
- 1003 25
- SHOW_DEBT
- 0
- ADD_EXPENSE
- 1003 500 Sutta 3 EXACT
- 1001 200
- 1002 200
- 1003 100
- SHOW_DEBT
- 0
- ADD_EXPENSE
- 1002 150 Sutta 2 EXACT
- 1003 150
- 1002 0
- SHOW_DEBT
- 0


### Output

- User with id 1001 owes amount 67.0 to User with id 1002
- User with id 1001 owes amount 167.0 to User with id 1003

---

## 🏗️ Recommended Class Design (LLD)
- `User` → id, name, email/phone.
- `Expense` → amount, paidBy, participants, splits, splitType.
- `Split` (abstract) → subclasses: `EqualSplit`, `ExactSplit`, `PercentSplit`.
- `BalanceSheet` → maintains mapping of who owes whom.
- `ExpenseService` → handles adding expenses and updating balances.
- `SplitwiseApp` (Driver) → main class to parse commands and run the app.

---

## 📝 Notes
- Keep input commands simple for quick testing.
- Focus on correctness and clarity over optimizations.
- Implement stretch goals only if core functionality is complete.
