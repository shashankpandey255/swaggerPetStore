package com.qa.restCalls;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.common.mapper.TypeRef;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import io.restassured.assertion.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Practice {
	public static Response response;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://opentdb.com/";

		response =

				when().get("/api.php?amount=10").then().extract().response();
	}

	/*
	 * This method is used to validate the schema of response.The
	 * answers-schema.json file is placed in classpath and then used the
	 * matchesJsonSchemaInClasspath for which static import of
	 * JsonSchemaValidator.matchesJsonSchemaInClasspath is done
	 */

	@Test
	public void getAnswers() {

		RestAssured.get("/api.php?amount=10").then().assertThat()
				.body(matchesJsonSchemaInClasspath("answers-schema.json"));

	}

	/*
	 * This method is validating the attribute response code to be 0
	 * 
	 */

	@Test
	public void verifyLength() {
		response.then().assertThat().body("response_code", equalTo(0));

	}

	/*
	 * This method is validating that the size of array in the response is 10.
	 */
	@Test
	public void getArrayLength() {

		List<String> categories = response.jsonPath().getList("results.category");
		assertThat(categories, hasSize(10));
	}
}
