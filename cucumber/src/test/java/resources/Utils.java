package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification req;
    //public String filePath = "/Users/nirmalsahu/IdeaProjects/cucumber/src/test/java/resources/global.properties";
    public RequestSpecification RequestSpecification() throws IOException {
        if(req==null) {
        PrintStream log = new PrintStream(new FileOutputStream("Logs.txt"));
//RestAssured.baseURI="https://rahulshettyacademy.com";

            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }

    return req;
}

public static String getGlobalValue(String key) throws IOException {
    Properties prop = new Properties();
    String filePath = "/Users/nirmalsahu/IdeaProjects/cucumber/src/test/java/resources/global.properties";
    FileReader reader=new FileReader(filePath);
    prop.load(reader);
    System.out.println("prop value - "+prop.getProperty(key));
    return prop.getProperty(key);

}

    public  static void setGlobalValue(String key, String value) throws IOException {
        Properties prop = new Properties();
        String filePath = "/Users/nirmalsahu/IdeaProjects/cucumber/src/test/java/resources/global.properties";
        FileReader reader=new FileReader(filePath);
        prop.load(reader);
        prop.setProperty(key,value);
        prop.store(new FileWriter(filePath),"Nirmal added this");
        System.out.println("set value - "+prop.setProperty(key,value));
        System.out.println("set value - "+prop.getProperty(key));


    }
    public String getJsonPath(Response response, String key){

        String resp=response.asString();

        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();

    }

}
