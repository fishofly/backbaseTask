# Automation Demo for a website


* Kotlin as the language for writing test scripts, fully compatible with Java but nicer
* Maven for building the project
* Selenide as the framework for writing GUI tests (Based on Selenium Webdriver), fully configurable
* Junit4 as the framework for launching tests
* Allure to create and effectively present reports
* RestAssured for API testing

Pom partially taken from https://github.com/allure-examples/allure-junit-example/blob/master/pom.xml

* Run test - mvn clean test -Dtestuser=... -Dtestpassword=...
* See report  - mvn allure:serve