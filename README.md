# Vending Machine - Low Level Design
A fully functional Vending Machine system implemented in Java using Object-Oriented Design principles and Design Patterns.

## Design Patterns Used
- **Singleton** - Single VendingMachine instance across the system
- **State** - Machine behavior changes based on current state (Idle, HasMoney, Dispensing)

## Core Features
### User
- Insert money (multiple denominations supported)
- Select product by slot code
- Cancel transaction - full refund
- Automatic change calculation (greedy algorithm - largest denomination first)
### Admin
- Add new product slots
- Restock existing slots
- Collect cash from machine
- Display inventory
## Validations & Edge Cases
- Insufficient funds → keep money, prompt to insert more or cancel
- Product out of stock → throw exception, keep money
- Invalid slot code → throw exception
- Change unavailable → dispense product, return whatever change possible

## Sample Output
<img width="875" height="428" alt="Screenshot 2026-06-08 at 2 01 22 AM" src="https://github.com/user-attachments/assets/ef3feae6-8573-4a5e-a2c1-1844d678ea46" />
