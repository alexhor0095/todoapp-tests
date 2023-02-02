package bdd

import io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite
@SelectClasspathResource("resources")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "bdd/steps")
class AddTasksTest {
}