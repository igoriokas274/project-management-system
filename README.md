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
1. Clone the source code of this project to your system via terminal or via your IDE
2. Startup earlier preinstalled MySQL Workbench tool:
   1. Create nuw connection with new credentials (if necessary)
   2. Open just created (or existed) connection and create a new schema. Name it "managerpro" or otherwise as you like
3. In your IDE tool:
    1. Open the cloned project:
    2. Open _src/main/resources/application.properties_ file to edit
    3. Edit _spring.datasource.url=_ line if created database with a different then "managerpro" name
    4. In lines _spring.datasource.username=_ and _spring.datasource.password=_ enter in Workbench tool created credentials to connect to database
    5. In _spring.jpa.hibernate.ddl-auto=_ line change **create-drop** value to **create**
    6. Open pom.xml file and edit <mysqldump.db>, <mysqldump.user> and <mysqldump.password> properties. Enter the same values as in steps before
    7. Open _src/main/java/dev/sda/team2/pma/ProjectManagementApplication.java_ file and Run the program
    8. If all the above steps are followed correctly, the IDE will create the entire database structure. Just refresh database in your Workbench tool, and you will convinced to this ;)
    9. Now you can Stop the program in IDE
    10. Open _src/main/resources/application.properties_ file again and in _spring.jpa.hibernate.ddl-auto=_ line change **create** value to **update**
    11. Run the program again
    
4. Open your browser:
   1. Go to link https://www.bcryptcalculator.com/ and generate BCrypt password for your application (eg. for a password "admin")
   2. Copy generated hash result (as $2a$10$gQ1IBZ1fNBfmcFu/5TqakutPFMK.3SEmunUKwh/5gbA0O.vAPysDe or something)
5. Go to your Workbench tool:
    1. Find _user_accounts_ table and view content of this table. It's empty! Right? :)
    2. Edit row of this table right from UI: 
       1. In _user_id_ column enter '1'
       2. Enter '1' in a column _enabled_ 
       3. Paste generated hash to column _password_
       4. In a column _role_ enter _ADMIN_ (it's Case sensitive) and _admin_ in _username_ column
       5. **Caution:** do not touch cell in _employee_id_ column!
    3. Press the _Apply_ button several times, then press _Close_. Congrats! You have just created the first Admin for the application! :)
6. if your application is still running, go to your browser (if not, Run application first):
    1. Enter _localhost:8080_ in address bar in your browser. You will see login page
    2. Enter here in a database created credentials (eg. Username 'admin' and password 'admin' as in my case)
7. That's it! You are at "Home"! :))) Now you can create new Users directly from the Admin Panel inside your launched application.
