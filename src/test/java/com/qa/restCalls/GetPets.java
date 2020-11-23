package com.qa.restCalls;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPets {
	PetDetails pet=new PetDetails();
	@Test
	public void get_availablePets() {

		List<Map<String, Object>> pets = get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
				.as(new TypeRef<List<Map<String, Object>>>() {
				});
		Assert.assertEquals(pets.get(0).get("id").toString(), "870");
		Assert.assertEquals(pets.get(0).get("name"), "doggie");

	}
	@Test
	public void post_availablePet() {
		pet.setStatus("Available");
				
		given().contentType("application/json").body(pet.createPet()).
		when().
			post("https://petstore.swagger.io/v2/pet").
		then().
			assertThat().statusCode(200).log().all();
	}
	@Test
	public void put_updatePet() {
		
		pet.setStatus("Sold");
		
		given().contentType("application/json").body(pet.createPet()).
		when().
			put("https://petstore.swagger.io/v2/pet").
		then().
			assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void deletePet() {
		
		given().contentType("application/json").
		when().
			delete("https://petstore.swagger.io/v2/pet/8585").
		then().
			assertThat().statusCode(200);
	}
	
}

