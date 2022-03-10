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

### Reports View
These are the screenshots of **Allure** reports:

![image](https://user-images.githubusercontent.com/36601919/157725835-f5fdc5cc-1705-4bef-9b84-2d1af6764b2a.png)

![image](https://user-images.githubusercontent.com/36601919/157726249-82a3238f-981c-4cd0-b59a-3746f823c59f.png)

