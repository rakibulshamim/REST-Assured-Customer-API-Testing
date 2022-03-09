# REST-Assured-Customer-API-Testing

A testing repository using **REST Assured** and **TestNG** to Automate Customer API and its suite of applications.


1. [Technology](#technology)
2. [Prerequisites](#prerequisites)
3. [How to run this project](#How-to-run-this-project)
4. [Reports View](#Reports-View)


### Technology:
- Tool: REST Assured
- IDE: IntelIJ
- Build tool: Gradle
- Language: Java
- Framework: TestNG

### Prerequisites
* Install jdk 8 or any LTS version
* Configure **JAVA_HOME** and **GRADLE_HOME**
* Download Allure latest version and configure system environment path
* Stable internet connection

### How to run this project
* Clone the repo in your local directory
* Open terminal to the project folder
* Run command `gradle clean test` to build the project
```
gradle clean test
```
6. Run command `allure generate allure-results --clean -o allure-report` to generate allure report.
```
allure generate allure-results --clean -o allure-report
```
7. Run command `allure serve allure-results` to generate html report and automatically open it in a web browser.
```
allure serve allure-results
```
