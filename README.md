
# Simple Coffee API Project: Instructions

The Project is based on a Spring BOOT framework using an in-memory H2 DB. 
A static **http://localhost:8080/index.html** page which is opened from the Server is included.

## Technologies:
    - Java version: 1.8.0_162-b12
    - Maven version: Apache Maven 3.5.3
    - IntelliJ Idea

## Tech Requirements:
JDK and Maven of the above specified versions (or similar).

The Application gets compiled and started with the Maven commands.
The Application implements a REST method, requests data from the H2 DB.

## Commands:
To compile the Application in \coffee, run: '**mvn clean install**' (compiled in project)
To start the Application (with compilation), run the Spring BOOT server in ..\subscription in the Console:
'**mvn spring-boot:run**' or **..\coffee\target>java -jar coffee-0.0.1-SNAPSHOT.jar**.

Then go to **http://localhost:8080/index.html** for simple check of requests.

Or use the below GET requests to test:

    - http://localhost:8080/coffee/fetchallorders.do
    - http://localhost:8080/coffee/fetchorderbyid.do?id=3
    - http://localhost:8080/coffee/fetchallcoffees.do
    - http://localhost:8080/coffee/fetchcoffeebyid.do?id=1

Once the Server has started, the schema and data creation in the H2 DB can be
checked: **http://localhost:8080/h2-console** .

Check that the JDBC URL is correct: **jdbc:h2:mem:coffee** , sa , no password

In the H2 Console, you will see ORDERS and COFFEES tables filled with test data.

### Implemented by Igor Maltsev