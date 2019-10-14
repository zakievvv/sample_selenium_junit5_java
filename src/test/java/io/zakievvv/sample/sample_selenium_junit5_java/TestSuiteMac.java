package io.zakievvv.sample.sample_selenium_junit5_java;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectPackages("io.zakievvv.sample.sample_selenium_junit5_java.tests")
public class TestSuiteMac {
}

