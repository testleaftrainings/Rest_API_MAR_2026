package com.testleaf.matschie.servicenow.steps;

import com.testleaf.matschie.general.utils.AllureHandler;

import io.cucumber.java.AfterAll;

public class Hooks {
	
	@AfterAll
	public static void afterAllScenarios() {
		AllureHandler.moveHistoryFolderToAllureResults();
	}

}