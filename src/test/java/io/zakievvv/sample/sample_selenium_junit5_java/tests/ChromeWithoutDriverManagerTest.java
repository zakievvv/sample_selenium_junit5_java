package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@Tag("mac")
@Tag("win")
public
class ChromeWithoutDriverManagerTest {
    private WebDriver driver;

    @BeforeEach
    void chromeSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
    }
    @Test
    void test(){
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals("Page not Found | Lazy Coder IO", driver.getTitle());
    }

    @AfterEach
    void testTeardown(){
        driver.quit();
    }
}
