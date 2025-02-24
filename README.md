# Accuweather Selenium Automation Project

## Overview
This project automates accuweather's core functionalities using **Selenium WebDriver, TestNG, and Java**.  
It follows the **Page Object Model (POM)** structure, ensuring better maintainability and scalability.


## Technologies Used
- **Java** – Core programming language
- **Selenium WebDriver** – Browser automation
- **TestNG** – Test execution and reporting
- **Maven** – Dependency management
- **Allure** – Test reporting

## Setup Instructions

### Clone the Repository
```sh
git clone https://github.com/mohammedWasik/Accuweather-Selenium.git

cd Wikipedia_Selenium

```
### Install Dependencies

```
mvn clean install
```
### Configure Properties
Edit the config.properties file in resources/ to update browser settings and URLs.

### Run Test

```sh
mvn test
```
### Generate Test Reports
To generate an Allure report, run:

```sh
allure serve target/allure-results
```


### Test Cases Covered
1.Cookie Acceptance Test – Check the acceptance feature of cookies of this site.

2.Cache Test – Checks if the recent searched city information shows up on home page.

3.Visitors Current Location Test – Verifies the Current Location functionality.


### Contributing
Feel free to contribute by submitting pull requests or reporting issues! 🚀

 Save and Push to GitHub

After writing your README file, save it and push it to GitHub:  

```sh
git add README.md
git commit -m "Added README"
git push origin main
```
