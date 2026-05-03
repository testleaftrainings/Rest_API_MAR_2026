/*
 * MIT License
 *
 * Copyright (c) 2022 TestLeaf
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.framework.data.dynamic;

import static com.framework.config.ConfigurationManager.configuration;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerDataFactory {

private static final Faker faker = new Faker(new Locale(configuration().faker()));
	
	public static String getName() {
		return faker.company().name().replaceAll("[^a-zA-Z ]", "");
	}
	
	public static String getEmailAddress() {
		return faker.internet().emailAddress();
	}
		
	public static String getAddress() {
		return faker.address().streetAddress();
	}
	
	public static String getCity() {
		return faker.address().city();
	}
	
	public static String getPostalCode() {
		return faker.address().countyByZipCode(getAddress());
	}
		
	public static String getFirstName() {
		return faker.name().firstName().replaceAll("[^a-zA-Z ]", "");
	}
	
	public static String getLastName() {
		return faker.name().lastName().replaceAll("[^a-zA-Z ]", "");
	}

	public static String getCompanyName() {
		return faker.company().name().replaceAll("[^a-zA-Z ]", "");
	}
	
		public static String getShortDesc() {
			return faker.lorem().sentence(3);
	}
	

	

}
