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
1. Create new Project and give it a name. Set project status to "in sales process". Fill all required info about it - start and stop dates, select customer etc.;
2. Create new Quotation. Set project number, fill comment (additional info about Quotation), set Type (retail, rent etc), set status (calculating, submitted etc). Add items from ITEMS list. Fill item quantity and selling price;
3. ....