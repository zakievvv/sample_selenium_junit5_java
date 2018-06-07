package io.zakievvv.sample.sample_selenium_junit5_java;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@IncludeTags("mac")
@SelectPackages("io.zakievvv.sample.sample_selenium_junit5_java.tests")
@RunWith(JUnitPlatform.class)
public class TestSuiteMac {
}
