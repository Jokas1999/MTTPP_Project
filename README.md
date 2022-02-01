
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->




<!-- PROJECT LOGO -->




<!-- TABLE OF CONTENTS -->




<!-- ABOUT THE PROJECT -->
## About The Project How To Run It



Simple automated test cases of websites,testing if the implemented functions work propertly. Run the tests by opening the project in `IntelliJ`,and running TestNG.xml file witch runs all five test cases.The results are genereted into the Results.html file inside the `target` folder using [extent reports](https://www.extentreports.com/) .



### Built With

Tools used:
* [Development Kit: JAVA JDK](https://www.oracle.com/java/technologies/downloads/#java8)
* [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/#section=windows)
* [Chrome driver](https://chromedriver.chromium.org/downloads)

Dependacies added to the pom.xml file used in tests to work correctly. All can be found in [maven repository](https://mvnrepository.com/).

* [selenium-java](https://www.selenium.dev/)
* [testng](testng)
* [maven-surefire-report-plugin](https://maven.apache.org/surefire/maven-surefire-report-plugin/)
* [maven-compiler-plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)
* [extent reports](https://www.extentreports.com/)


<p align="right">(<a href="#top">back to top</a>)</p>






### Test Cases and short explanation:
* FeritTest - Simple test starting from google.com,that leads to ferit.hr site and interacting with the website.
* NikeWebsiteTest - Interacting with Nike shop website and interacting with drop down menus.
* YoutubeTest - Browsing youtube,and checking the results of search.
* RegisterTest - Filling out a register form and succesefuly registering,added generator for random emails,so that the test can be reused without manualy changing email adress.
* LoginTest - Testing log-in on the same website.


<!-- GETTING STARTED -->
