package starter;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")  //if you comment out this line, NoTestsDiscoveredException: Suite [starter.AcceptanceTestSuite] did not discover any tests error occurs
//@ConfigurationParameter(key = "cucumber.publish.enabled", value = "true") can be used instead of .properties file
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") // to see feature steps on the console
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "starter") //the package where your runner step definitions are

public class AcceptanceTestSuite {
}
