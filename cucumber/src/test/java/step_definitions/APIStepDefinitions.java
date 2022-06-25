package step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import resources.APIResourcesEnum;
import resources.TestDataBuild;
import resources.Utils;
import supporting_files.pojo.AddPlace;
import supporting_files.pojo.Location;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APIStepDefinitions extends Utils {

    public Response response;
    public ResponseSpecification resSpec;
   // public RequestSpecification req;
    public RequestSpecification res;
    public TestDataBuild data = new TestDataBuild();
    static String place_id;

    @Given("^Add Place payload$")
    public void add_Place_payload() throws Exception {
        res = given().spec(RequestSpecification())
                .body(data.addPlacePayload());
    }

    @Given("^Add Place payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_Place_payload_with(String name, String language, String address) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(RequestSpecification())
                .body(data.addPlacePayloadWithArg(name,language,address));
    }

    @When("^user call \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_call_with_http_request(String resourceName, String httpMethod) throws Exception {
        APIResourcesEnum resourcesAPI= APIResourcesEnum.valueOf(resourceName);
        System.out.println("value of '"+resourceName+ "' resource is - "+resourcesAPI.getResource());
        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if(httpMethod.equalsIgnoreCase("POST")) {
            response = res.when().post(resourcesAPI.getResource())
                    .then().log().all().spec(resSpec)
                    .extract().response();
        }
        else if(httpMethod.equalsIgnoreCase("GET")) {
            response = res.when().get(resourcesAPI.getResource())
                    .then().log().all().spec(resSpec)
                    .extract().response();
        }

        String strResponse = response.asString();
        System.out.println("String Response - "+"\n"+strResponse);
    }

    @Then("^The API call got success with status code (\\d+)$")
    public void the_API_call_got_success_with_status_code(int arg1) throws Exception {
        //JsonPath js = new JsonPath(strResponse);
        assertEquals(response.getStatusCode(),200);
    }

    @Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void in_response_body_is(String keyValue, String expectedKeyValue) throws Exception {
        // Write code here that turns the phrase above into concrete actions
//        String strResponse = response.asString();
//        JsonPath js = new JsonPath(strResponse);
//        assertEquals( js.get(keyValue).toString(),expectedKeyValue);
        assertEquals(getJsonPath(response,keyValue),expectedKeyValue);

    }
    @Then("^I set value of \"([^\"]*)\" as \"([^\"]*)\"$")
    public void i_set_value_of_as(String key, String value) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Utils.setGlobalValue(key,value);
    }

    @Then("^Verify place_id created map to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_place_id_created_map_to_using(String expectedName, String resource) throws Exception {
        // Write code here that turns the phrase above into concrete actions
         place_id=getJsonPath(response,"place_id");
        res=given().spec(RequestSpecification()).queryParam("place_id",place_id);
        user_call_with_http_request(resource,"GET");
        String actualName = getJsonPath(response,"name");
        assertEquals(expectedName,actualName);

    }

    @Given("^deletePlace payload$")
    public void deleteplace_payload() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(RequestSpecification())
                .body(data.deletePlacePayload(place_id));
    }
}
