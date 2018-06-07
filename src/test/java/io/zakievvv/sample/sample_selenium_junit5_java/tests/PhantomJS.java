package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


@Tag("mac")
@Tag("win")
class PhantomJS {
    private WebDriver driver;

    @BeforeEach
    void phantomJSSetup() {
        WebDriverManager.phantomjs().setup();
        driver = new PhantomJSDriver();
    }

    @Test
    void test() {
        this.driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterEach
    void testTeardown() {
        driver.quit();
    }
}