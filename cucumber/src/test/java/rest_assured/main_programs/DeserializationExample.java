package rest_assured.main_programs;


import io.restassured.RestAssured;
import supporting_files.pojo.AddPlace;
import supporting_files.pojo.DeserializeResponse;
import supporting_files.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class DeserializationExample {
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
        DeserializeResponse response =RestAssured.given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","Application/Json")
                .body(p)
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().as(DeserializeResponse.class);
        System.out.println("status  - " + response.getStatus());
        System.out.println("place_id - " + response.getPlace_id());
        System.out.println("scope - " + response.getScope());
        System.out.println("reference - " + response.getReference());
        System.out.println("id - " + response.getId());

        /*
        Key out - Holding response as Deserialize.class is key point to remember
         */

    }
}
