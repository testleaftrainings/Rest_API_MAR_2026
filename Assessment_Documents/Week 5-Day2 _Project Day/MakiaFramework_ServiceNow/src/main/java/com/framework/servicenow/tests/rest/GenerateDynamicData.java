package com.framework.servicenow.tests.rest;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GenerateDynamicData {
	
	@Test
	public void dynamicData() {
	Faker fake=new Faker();
	String firstName = fake.name().firstName();
	String lastName = fake.name().lastName();
	String username = fake.name().username();
	String emailAddress = fake.internet().emailAddress();
	System.out.println("FirstName is ---"+firstName);
	System.out.println("LastName is ---"+lastName);
	System.out.println("Username is ---"+username);
	System.out.println("Email is ---"+emailAddress);
	}

}
