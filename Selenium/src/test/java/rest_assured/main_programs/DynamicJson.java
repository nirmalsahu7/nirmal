package rest_assured.main_programs;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.supporting_files.Payload;
import rest_assured.supporting_files.ReusableMethods;

import static io.restassured.RestAssured.given;
@Test(dataProvider="BooksData")
public class DynamicJson {
    //public static void main(String[] args) {

    public void manageBook(String isbn, String asile){
       // RestAssured.baseURI="http://216.10.245.166";
        RestAssured.baseURI="https://rahulshettyacademy.com";


        String response= given().log().all().header("Content-Type","Application/Json")
                .body(Payload.addBook(isbn,asile))
                .when()
                .post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.printf("response" + "\n"+response);
        JsonPath js = ReusableMethods.rawToJson(response);
        String id=js.get("ID");
        System.out.println("id = "+id);

    }

    @DataProvider(name="BooksData")
    public Object[][] getData(){
      return  new Object[][]{{"abab1","1212"},{"acac1","1313"},{"adad1","1414"}};
    }
}
