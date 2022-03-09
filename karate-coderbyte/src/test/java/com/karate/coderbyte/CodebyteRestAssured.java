package com.karate.coderbyte;

import static io.restassured.RestAssured.when;

import java.util.ArrayList;

public class CodebyteRestAssured {
	public static void main(String[] args) {
		getSpecificPartOfResponseBody();
	}

	public static void getSpecificPartOfResponseBody() {

		String url = "https://coderbyte.com/api/challenges/json/rest-get-simple";
		ArrayList<String> hobbies = when().get(url).then().extract().path("hobbies");

		for (int i = 1; i <= hobbies.size(); i++) {

			System.out.println("ITEM" + i + ": " + hobbies.get(i - 1));
		}
	}

}
