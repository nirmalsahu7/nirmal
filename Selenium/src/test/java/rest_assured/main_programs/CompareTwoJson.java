package rest_assured.main_programs;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.testng.Assert;
import rest_assured.supporting_files.Payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


public class CompareTwoJson {
    public static void main(String[] args) throws JsonProcessingException, JSONException {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response1=  RestAssured.given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json")
                .body(Payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();
        System.out.println("response - " +response1);
        System.out.println("payload - " +Payload.addPlace());
        ObjectMapper mapper = new ObjectMapper();
        JsonPath js1=new JsonPath(Payload.addPlace());
        JsonPath js2=new JsonPath(response1);

        String response2=response1;
        response2=response2.replace("status","STATUS");
//        JsonNode actualObj1 = mapper.readTree(response1);
//        JsonNode actualObj2 = mapper.readTree(Payload.addPlace());
//        JsonNode.equals
       // assertEquals(mapper.readTree(s1), mapper.readTree(s2));
       //assertEquals(mapper.readTree(response1), mapper.readTree(Payload.addPlace())); // with string
        //assertEquals(mapper.readTree(js1), mapper.readTree(js2)); // with object
        JSONCompareResult result =
                JSONCompare.compareJSON(response1, response2, JSONCompareMode.STRICT);
        System.out.println(result.toString());

        //ObjectMapper mapper = new ObjectMapper();
        response1=response1.replace("OK","");
        JsonNode tree1 = mapper.readTree(response1);
        JsonNode tree2 = mapper.readTree(response2);

        boolean areTheyEqual = tree1.equals(tree2);

        System.out.println("result areTheyEqual -"+areTheyEqual);
        System.out.println("has -"+tree1.hasNonNull("status"));

    }


}
