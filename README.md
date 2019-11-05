### Jmeter Tests
     `mvn jmeter:jmeter -f pom.xml`

### Selenium Tests
     `mvn test  -Dsurefire.suiteXmlFiles=mac-only.xml`
     `allure serve allure-results`

![](selenium-junit5.gif)
