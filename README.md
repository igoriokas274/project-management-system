# Project management application (PMA)

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

## Software requirements
1. Java SDK 1.8
2. Git
3. MySQL or MariaDB
4. MySQL Workbench tool
5. Any IDE (IntelliJ, Eclipse or Netbeans)

## Getting started
#### Updated 2021-01-17
1. Clone the source code of this project to your system via terminal or via your IDE
2. Startup earlier preinstalled MySQL Workbench tool:
   1. Create new connection with new credentials (if it is necessary)
   2. Open just created (or existed) connection and create a new schema. Name it "managerpro" or otherwise as you like
3. In your IDE tool:
    1. Open the cloned project:
    2. Open _src/main/resources/application.properties_ file to edit
    3. Edit _spring.datasource.url=_ line if created database with a different then "managerpro" name
    4. In lines _spring.datasource.username=_ and _spring.datasource.password=_ enter in Workbench tool created credentials to connect to database
    5. Open pom.xml file and edit <mysqldump.db>, <mysqldump.user> and <mysqldump.password> properties. Enter the same values as in steps before
    6. Open _src/main/java/dev/sda/team2/pma/ProjectManagementApplication.java_ file and Run the program
    7. If all the above steps are followed correctly, the IDE will create the entire database structure and load initial data. Just refresh database in your Workbench tool, and you will convinced to this ;)
    8. Now you can Stop the program in IDE
    9. App initialize SQL Data after every restart. If you want to prevent this, open _src/main/resources/application.properties_ file again and change _spring.jpa.hibernate.ddl-auto = create_ to _update_ and _spring.datasource.initialization-mode=always_ to _never_
    10. Run the app again.
4. Go to your browser:
    1. Enter _localhost:8080_ in address bar. You will see login page
    2. Enter default initialized credentials - Username: _admin_ / password: _admin_ or Username: _user_ / password: _user_
5. That's it! You are at "Home"! :))) Now you can create new Users directly from the Admin Panel inside your launched application.

#### JavaMelody Framework enabled
1. Default port: 8081
2. default path: /actuator/monitoring
   
Note:
- for ADMIN role only
- User Guide: https://github.com/javamelody/javamelody/wiki/UserGuide
