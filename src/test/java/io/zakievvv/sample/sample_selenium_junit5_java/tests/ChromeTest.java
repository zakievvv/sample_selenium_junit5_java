package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Tag("mac")
@Tag("win")
public
class ChromeTest {
    private  WebDriver driver;

    @BeforeEach
    void chromeSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
