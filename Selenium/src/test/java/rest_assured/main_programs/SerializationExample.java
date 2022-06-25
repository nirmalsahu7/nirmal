package rest_assured.main_programs;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import rest_assured.supporting_files.pojo.AddPlace;
import rest_assured.supporting_files.pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializationExample {
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

        RestAssured.baseURI="https://rahulshettyacademy.com";
        Response response =given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json")
                .body(p)
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .extract().response();
        String strResponse = response.asString();
        System.out.println("String Response - "+"\n"+strResponse);

        /*
        Key note - preparing body as a main parent class is the key point here
         */

    }
}
