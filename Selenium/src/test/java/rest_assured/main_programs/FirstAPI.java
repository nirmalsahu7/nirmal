package rest_assured.main_programs;


import io.restassured.RestAssured;
import rest_assured.supporting_files.Payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstAPI {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json")
                .body(Payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.41 (Ubuntu)");
    }
}
