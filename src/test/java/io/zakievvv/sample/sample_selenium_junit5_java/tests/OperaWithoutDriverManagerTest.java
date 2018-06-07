package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import io.qameta.allure.Flaky;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


@Tag("mac")
@Tag("win")
@Flaky
class OperaWithoutDriverManagerTest {
    private WebDriver driver;

    @BeforeEach
    void operaSetup() {
        DesiredCapabilities capabilities = DesiredCapabilities.opera();
        OperaOptions options = new OperaOptions();
        capabilities.setCapability(OperaOptions.CAPABILITY, options);
        driver = new OperaDriver(capabilities);
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
