package com.testleaf.matchie.servicenow.steps;

import java.util.List;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.testleaf.matschie.general.utils.TestUtlis;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class AssertionSteps {

	@Then("response should be success")
	public void response_should_be_success(DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		for (Map<String, String> map : asMaps) {
			MatcherAssert.assertThat(TestUtlis.getResponse().getStatusCode(),
					Matchers.equalTo(Integer.parseInt(map.get("statusCode"))));
			MatcherAssert.assertThat(TestUtlis.getResponse().getStatusLine(),
					Matchers.containsString(map.get("statusMessage")));
			MatcherAssert.assertThat(TestUtlis.getResponse().getContentType(),
					Matchers.containsStringIgnoringCase(map.get("responseFormat")));
		}
	}
}