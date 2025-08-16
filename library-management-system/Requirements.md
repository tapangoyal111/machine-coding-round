# Library Management System

## Problem Statement
You are tasked with designing and implementing a **Library Management System** for a small local library.  
The system should allow:
- Managing books (add, search, remove)
- Managing members (add, view, remove)
- Borrowing and returning books
- Tracking overdue books

This is a **simplified** version and should be possible to implement within **90–120 minutes**.

---

## Functional Requirements

### **1. Book Management**
- **Add Book**
    - Each book has:
        - `id` (unique identifier)
        - `title`
        - `author`
        - `publishedYear`
        - `totalCopies`
        - `availableCopies`
- **Search Book**
    - By title, author, or both
    - Partial matches should work
- **Remove Book**
    - Only if no copies are currently issued

---

### **2. Member Management**
- **Add Member**
    - Each member has:
        - `id` (unique identifier)
        - `name`
        - `membershipDate`
- **View Members**
- **Remove Member**
    - Only if they have no books issued

---

### **3. Borrowing Books**
- A member can borrow a book if:
    - `availableCopies > 0`
    - The member has fewer than `maxBooksAllowed` (configurable, default = 5)
- When borrowing:
    - Reduce `availableCopies` by 1
    - Store:
        - `bookId`
        - `memberId`
        - `borrowDate`
        - `dueDate` (default = 14 days from borrow date)

---

### **4. Returning Books**
- Increase `availableCopies` by 1
- Remove the borrowing record
- If returned after `dueDate`, mark as **overdue** (late fee calculation optional)

---

### **5. Overdue Tracking**
- Provide a method to **list all overdue books** for all members

---

## Non-Functional Requirements
- Code should follow **SOLID principles**
- Use **clean OOP design**
- Write **modular classes** for:
    - Book
    - Member
    - Library
    - BorrowingRecord (optional)
- No database is needed — store data **in memory**
- Use **Java Collections** for storage

---

## Input/Output Examples

AddBook "The Hobbit" "J.R.R. Tolkien" 1937 3
Book added successfully. ID: 1

AddMember "Alice"
Member added successfully. ID: 101

BorrowBook 101 1
Book borrowed successfully. Due date: 2025-08-24

ListOverdueBooks
No overdue books.

ReturnBook 101 1
Book returned successfully.

### Example Flow
