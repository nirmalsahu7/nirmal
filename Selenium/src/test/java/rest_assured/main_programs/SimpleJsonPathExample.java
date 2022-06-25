package rest_assured.main_programs;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import rest_assured.supporting_files.Payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleJsonPathExample {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response =given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json")
                .body(Payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))

                .header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println("complete response as string - "+response);
        JsonPath js = new JsonPath(response);
        String placeId=js.getString("place_id");
        System.out.println("place_id from response string - "+placeId);

    }
}
