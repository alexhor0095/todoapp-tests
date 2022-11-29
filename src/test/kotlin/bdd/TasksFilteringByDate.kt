package bdd

import io.cucumber.core.options.Constants
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite
@SelectClasspathResource("resources/features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "bdd/steps")
class TasksFilteringByDate {
}