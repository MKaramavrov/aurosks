![](Auros-knowledge-systems-logo.png)
# Project's description:
Entities description: </br>
K-PAC (Knowledge Package) - an entity that stores the contents of any knowledge. It contains
the next fields:</br>
● **_ID_** - unique numeric field, the occurrence of K-PAC.</br>
● **_Title_** - character string (up to 250 characters)</br>
● **_Description_** - character string (up to 2000 characters), information about the contents of
K-PAC.</br>
● **_Creation date_** - a string in the format DD-MM-YYYY, the date when K-PAC was created.</br>

K-PAC Set is an entity that can contain multiple K-PAC entities. It contains the next fields:</br>
● **_ID_** - unique numeric field, the occurrence of the K-PAC Set.</br>
● **_Title_** - a character string (up to 250 characters).</br>

### This project consists of 3 Architecture layers:
1. Presentation tier(Controller)
2. Application tier(Service)
3. Data tier(Dao)

### Project's structure:
* **_Controller_** - contains HttpServlets and is responsible for handling requests and responses;
* **_Service_** - contains all business logic of the application;
* **_Exception_** - contains custom exceptions;
* **_Model_** - contains entities which we operate during application usage;
* **_Util_** - contains ConnectionUtil which is responsible for connection with Database;
* **_Dao_** - contains dao classes and interfaces which are responsible to interact with Database;


### Technologies used in project
* Java 8+ 
* Spring (JDBC, MVC)
* Maven
* Database - MySQL
* IDE - IntelliJ IDEA