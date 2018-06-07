# Test Framework Overview
Core consists of:
 - Junit5
 - Allure reports
 - Slack IM integration (just a stub for now)
 - Selenium
 - Selenium WebDriver manager.
     
    This manager automatically updates and uses most recent versions of:
    Chrome, Firefox, Opera, PhantomJS, Microsoft Edge, and Internet Explorer

### Mac OS Setup

   ```
   sh mac-bootstrap.sh
   ```

This script installs the following if something is absent:

1. Installs Homebrew `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
2. Installs Caskroom `brew tap caskroom/cask`
3. If you dont have the Java Development Kit (JDK) runs this command `brew cask install java`
4. Installs Maven `brew install maven`
5. Runs `./mac_install_browsers.sh`

The script also runs the tests.

#### Safari usage

Safari requires the following manual steps for tests execution:

1. Open Safari Preferences
2. Go to the Advanced Tab
3. Check the box at the bottom "Show Develop menu in menu bar"
4. Click on the Develop menu 
5. Click on "Allow Remote Execution"

At the time of execution there may also be a pop up message - press option to agree with auto test session

### Running Tests on Mac OS X
   `mvn test  -Dsurefire.suiteXmlFiles=mac-only.xml`   

### Show Reports
   `allure serve allure-results`

### Script to run tests and show report:
    `kickstart_with_reports_on_mac.sh`

## Sections below are not confirmed as working 

### Windows Setup

1. Right-Click on `windows_install.bat` and select `Run as Administrator`
2. Test the installation by executing the following

   `mvn test  -Dsurefire.suiteXmlFiles=windows-only.xml`
#### Instructions for the Windows package manager
This is needed if Selenium WebDriver Manager does not work for any reason.

1. The `windows_install.bat` script should install Chocolatey the Windows package manager.
2. Install latest versions of 
    a. Firefox
    b. Chrome
    c. PhantomJS
3. Selenium drivers for the above and the Edgedriver   
   
### Running Tests on Windows
   `mvn test  -Dsurefire.suiteXmlFiles=windows-only.xml`
   
### Scripts for Running, Reporting, Managing Reports
   Mac OS X only - I do not have Windows machine right now
   Currently is work in progress
   `kickstart_with_reports.sh`
   
## Credits and References
 - [Junit5](https://www.junit.org)
 - [Mavenized Project sample](https://github.com/lazycoderio/Basic-Selenium-Java)
 - [Web Driver Manager](https://github.com/bonigarcia/webdrivermanager)
 - [Build tool - Maven](https://maven.apache.org)
 - [Allure reports](https://docs.qameta.io/allure/#_about)
 - [Slack WebHook](https://github.com/gpedro/slack-webhook)
 
Best Regards,

Evgenii Zakiev

zakievvv@gmail.com

+1(512)8176082
 
    
