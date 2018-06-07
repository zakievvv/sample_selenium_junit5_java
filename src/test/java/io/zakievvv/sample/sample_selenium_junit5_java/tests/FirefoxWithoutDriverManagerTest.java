package io.zakievvv.sample.sample_selenium_junit5_java.tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


@Tag("mac")
@Tag("win")
class FirefoxWithoutDriverManagerTest {
    private WebDriver driver;

    @BeforeEach
    void firefoxSetup() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        // mac requires the binary location to be set for firefox, not sure why at time of update
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            FirefoxBinary ff = new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin"));
            FirefoxProfile ffp = new FirefoxProfile();
            driver = new FirefoxDriver(ff, ffp, capabilities);
        } else {
            driver = new FirefoxDriver();
        }
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

