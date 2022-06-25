package rest_assured.main_programs;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import rest_assured.supporting_files.pojo.AddPlace;
import rest_assured.supporting_files.pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqResSpecBuilder {
    public static void main(String[] args) {


        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setName("Frontline house");
        p.setPhone_number("+91) 983 893 3937");
        p.setAddress("29, side layout, cohen 09");
        p.setWebsite("http://google.com");
        p.setLanguage("French-IN");
        List<String> myList = new ArrayList<>() ;
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        Location l=new Location();
        l.setLat(38.383494);
        l.setLng(33.427362);
        p.setLocation(l);


       RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();
        ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        RequestSpecification res = given().spec(req)
                .body(p);

        Response response= res.when().post("maps/api/place/add/json")
                .then().log().all().spec(resSpec)
                .extract().response();
        String strResponse = response.asString();
        System.out.println("String Response - "+"\n"+strResponse);

        /*
        Key note -
        RequestSpecification - where you set
        ResponseSpecBuilder - where you expect
         */

    }
}
