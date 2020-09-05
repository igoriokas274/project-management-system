# Project management system (PMS)

## DB tables
1. CONTACTS - isEmployee, isCustomer or isSupplier all in one table;
2. ITEMS - List of items --> id, stockId, name, description, price, supplierId etc;
3. PROJECTS - Main info about Project --> id, name, status, start date, end date, manage, members, customer etc;
4. STATUS - Status list for PROJECTS --> in sales process, signed agreement, project work completed, project rejected etc;
5. STOCKS - The list of Stocks --> main stock, project stock etc;
6. QUOTATIONS ...
7. ORDERS ...

## System description (working procedures)
1. Sales Manager - Create new Project and give it a name. Set project status to "in sales process". Fill all required info about it - start and stop dates, select customer etc.;
2. Sales Manager - Create new Quotation. Set project number, fill comment (additional info about Quotation), set Type (retail, rent etc), set status (calculating, submitted etc). Add items from ITEMS list. Fill item quantity and selling price. NOTE: Each Project can contains many Quotations with different statuses;
3. Sales Manager - When the customer approves the Quotation and/or the contract is signed, the status in the Project module and in the Quotation must be changed. Quotation must be set as CONFIRMED;
4. Sales Manager - From CONFIRMED quotation user must create ORDER. From this point Project Manager works only with ORDERS;
5. Project Manager - in Order set Items delivery terms;
6. Supply Manager - orders goods, that are not currently in Stock, form items list in Order;
7. Project Manager - when goods are delivered in Stock, the Project Manager can deliver them to the project or return them from project to main stock;
8. Project Manager - from Order module can form an Invoice from the Items delivered in the project.
9. ...