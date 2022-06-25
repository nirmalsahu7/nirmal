package rest_assured.main_programs;


import io.restassured.RestAssured;
import supporting_files.Payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OAuth2V2 {
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
