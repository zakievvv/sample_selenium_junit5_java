package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


@Tag("win")
class EdgeWithoutDriverManager {
    private WebDriver driver;

    @BeforeEach
    void edgeSetup() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        driver = new EdgeDriver(capabilities);
    }

    @Test
    void test() {
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterEach
    void testTeardown() {
        driver.quit();
    }
}
