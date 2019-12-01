package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(OrderAnnotation.class)
public class AcmeTests {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        switch(System.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "phantomjs":
                WebDriverManager.phantomjs().setup();
                driver = new PhantomJSDriver();
                break;
        }
    }

    @Test
    @Order(1)
    void testOpenAcmeBank() {
        driver.get("https://demo.applitools.com/");
        Assert.assertEquals("ACME demo app", driver.getTitle());
    }

    @Test
    @Order(2)
    void testSignInAcmeBank()  {
        WebElement fieldUsername = driver.findElement(By.id("username"));
        WebElement fieldPassword = driver.findElement(By.id("password"));
        WebElement buttonSignIn = driver.findElement(By.id("log-in"));

        fieldUsername.click();
        fieldUsername.sendKeys("JackGomez");
        fieldPassword.click();
        fieldPassword.sendKeys("password12345");
        buttonSignIn.click();
        WebElement fieldCustomerName = driver.findElement(By.className("logged-user-name"));
        Assert.assertEquals("Jack Gomez", fieldCustomerName.getText());
    }

    @Test
    @Order(3)
    void testMainPageBalances()  {
        List<WebElement> fieldTotalBalances = driver.findElements(By.className("balance-value"));

        Assert.assertEquals(3, fieldTotalBalances.size());

        Assert.assertNotNull(fieldTotalBalances.get(0).getText());
        Assert.assertTrue(fieldTotalBalances.get(0).getText().contains("$350")
                && fieldTotalBalances.get(0).getText().contains("%7"));

        Assert.assertNotNull(fieldTotalBalances.get(1).getText());
        Assert.assertEquals("$17,800", fieldTotalBalances.get(1).getText());

        Assert.assertNotNull(fieldTotalBalances.get(2).getText());
        Assert.assertEquals("$180", fieldTotalBalances.get(2).getText());
    }

    @Test
    @Order(4)
    void testMainPageNavigationBarLeft()  {

        List<WebElement> buttonProfileOnNavBarLeft = driver.findElements(
                By.cssSelector("body > div > div.top-bar.color-scheme-bright > div.top-menu-controls > div.logged-user-w > div > div > img"));
        Assert.assertTrue(buttonProfileOnNavBarLeft.size() == 1);

        WebElement linkCreditCards = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.menu-w.color-scheme-light.color-style-transparent.menu-position-side.menu-side-left.menu-layout-compact.sub-menu-style-over.sub-menu-color-bright.selected-menu-color-light.menu-activated-on-hover.menu-has-selected-link > ul > li.selected.has-sub-menu > a > span"));
        Assert.assertEquals("Credit cards", linkCreditCards.getText());

        WebElement linkDebitCards = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.menu-w.color-scheme-light.color-style-transparent.menu-position-side.menu-side-left.menu-layout-compact.sub-menu-style-over.sub-menu-color-bright.selected-menu-color-light.menu-activated-on-hover.menu-has-selected-link > ul > li:nth-child(3) > a > span"));
        Assert.assertEquals("Debit cards", linkDebitCards.getText());

        WebElement linkLoans = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.menu-w.color-scheme-light.color-style-transparent.menu-position-side.menu-side-left.menu-layout-compact.sub-menu-style-over.sub-menu-color-bright.selected-menu-color-light.menu-activated-on-hover.menu-has-selected-link > ul > li:nth-child(5) > a > span"));
        Assert.assertEquals("Loans", linkLoans.getText());

        WebElement linkMortgages = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.menu-w.color-scheme-light.color-style-transparent.menu-position-side.menu-side-left.menu-layout-compact.sub-menu-style-over.sub-menu-color-bright.selected-menu-color-light.menu-activated-on-hover.menu-has-selected-link > ul > li:nth-child(6) > a > span"));
        Assert.assertEquals("Mortgages", linkMortgages.getText());
    }

    @Test
    @Order(5)
    void testMainPageNavigationBarTop() throws InterruptedException {
        WebElement linkLogo = driver.findElement(By.className("logo-label"));
        Assert.assertEquals("ACME", linkLogo.getText().trim());

        WebElement inputFieldSearch = driver.findElement(
                By.cssSelector("body > div > div.top-bar.color-scheme-bright > div.top-menu-controls > div.element-search.autosuggest-search-activator > input[type=text]"));
        String fieldSearchText = inputFieldSearch.getAttribute("Placeholder");
        Assert.assertEquals("Start typing to search...", fieldSearchText);

        List<WebElement> buttonNotifications = driver.findElements(
                By.cssSelector("body > div > div.top-bar.color-scheme-bright > div.top-menu-controls > div.messages-notifications.os-dropdown-trigger.os-dropdown-position-left > i"));
        Assert.assertTrue(buttonNotifications.size() == 1);

        List<WebElement> buttonSettings = driver.findElements(
                By.cssSelector("body > div > div.top-bar.color-scheme-bright > div.top-menu-controls > div.top-icon.top-settings.os-dropdown-trigger.os-dropdown-position-left > i"));
        Assert.assertTrue(buttonSettings.size() == 1);

        List<WebElement> buttonProfileOnTopBar = driver.findElements(
                By.cssSelector("body > div > div.top-bar.color-scheme-bright > div.top-menu-controls > div.logged-user-w > div > div > img"));
        Assert.assertTrue(buttonProfileOnTopBar.size() == 1);
    }

    @Test
    @Order(6)
    void testMainPageSectionFinancialOverview() {
        WebElement sectionFinancialOverview = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.content-w > div > div > div.element-wrapper.compact.pt-4 > h6.element-header"));
        Assert.assertEquals("Financial Overview", sectionFinancialOverview.getText().trim());

        WebElement buttonAddAccount = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.content-w > div > div > div.element-wrapper.compact.pt-4 > div.element-actions > a.btn.btn-primary.btn-sm > span"));
        Assert.assertEquals("Add Account",buttonAddAccount.getText());

        WebElement buttonMakePayment = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.content-w > div > div > div.element-wrapper.compact.pt-4 > div.element-actions > a.btn.btn-success.btn-sm > span"));
        Assert.assertEquals("Make Payment",buttonMakePayment.getText());

        WebElement linkViewStatements = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.content-w > div > div > div.element-wrapper.compact.pt-4 > div.element-box-tp > div > div > div > div.balance.hidden-mobile > div.balance-link > a > span"));
        Assert.assertEquals("View Statement", linkViewStatements.getText());

        WebElement linkRequestIncrease = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.content-w > div > div > div.element-wrapper.compact.pt-4 > div.element-box-tp > div > div > div > div:nth-child(2) > div.balance-link > a > span"));
        Assert.assertEquals("Request Increase", linkRequestIncrease.getText());

        WebElement linkPayNow = driver.findElement(
                By.cssSelector("body > div > div.layout-w > div.content-w > div > div > div.element-wrapper.compact.pt-4 > div.element-box-tp > div > div > div > div:nth-child(3) > div.balance-link > a > span"));
        Assert.assertEquals("Pay Now", linkPayNow.getText());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    static void testTeardown(){
        driver.quit();
    }
}
