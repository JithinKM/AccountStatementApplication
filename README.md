# AccountStatementApplication
An application to fetch the statements for a given account.

## prerequisites
- Java 17
- Maven 3.9.3

## Build and generate the test coverage report

- Run the following command from the project root directory to build the application:

(This command will the unit test cases too. The Jacoco test coverage report will be generated at: `target/site/jacoco/index.html`)

`mvn clean install`

- Build application by skipping the unit tests.

`mvn clean install -DskipTests`

## Code Analysis with SonarQube


Run the following command to generate the Sonar report.
The SonarQube in stance must be running on our localhost.

`mvn sonar:sonar -Dsonar.login={sonarqube-token}`

sonarqube-token: Generated from the SonarQube application.

## Run the application
Start the application by executing the following command from the project root directory:
`java -jar .\target\assignment-0.0.1-SNAPSHOT.jar`

The application can now be accessed at the following URL:
`http://localhost:8080`

## API Endpoints

#### /account/3?fromDate={fromDate}&toDate={toDate}&fromAmount={fromAmount}&toAmount={toAmount}

Users with the role `USER` cannot access the API with query params, users with the role `ADMIN` can access the API with or without the query params.

The users with the role `USER` can see the past 3 months statement only.

If any of the fromDate or toDate are missing, the API will return last 3 months statement.

If fromAmount is missing, it will be substituted as 0 and if the toAmount is missing, it will be substituted as maximum of long value.
