# Project management system (PMS)

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

## Issues

### **Issue #1** - Hibernate does not create Relations between database keys.
---
    System info:
```
 name : MySQL
    version : 5.5.5-10.5.5-MariaDB
      major : 5
      minor : 5
2020-Sep-17 00:39:03 AM [main] DEBUG org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator - Driver ->
       name : MySQL Connector/J
    version : mysql-connector-java-8.0.16 (Revision: 34cbc6bc61f72836e26327537a432d6db7c77de6)
      major : 8
      minor : 0
```
---
### Solution 
The root of the problem is in the line `<property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>` in hibernate.cfg.xml.

This type of Dialect creates DB with MyISAM Engine by default (maybe in performace reasons). Relations appears if Engine is changed in InnoDB.

To do this, you must select a different type of Dialect - _MySQL5InnoDBDialect_.
***
***Note:*** Pay no attention if IntelliJ crosses out this line `<property name="dialect">org.hibernate.dialect.MySQL5InnoDBDialect</property>` The Code works anyway :)



