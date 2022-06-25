package rest_assured.main_programs;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import supporting_files.Payload;
import supporting_files.ReusableMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MultipleAPI {
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
//update place
        String newAddress = "400 CAMELOT CT,PA";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        // GET API
        String getResponse=given().log().all().queryParam("key","qaclick123")
                .queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

       // JsonPath js1 = new JsonPath(getResponse);
        JsonPath js1=ReusableMethods.rawToJson(getResponse);
        String actualAddress=js1.getString("address");
        System.out.println("address-"+actualAddress);
        Assert.assertEquals(actualAddress,newAddress);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actualAddress,"abc");
        System.out.println("after soft assert-");
    }
}
