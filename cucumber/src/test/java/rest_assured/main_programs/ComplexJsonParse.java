package rest_assured.main_programs;


import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import supporting_files.Payload;

public class ComplexJsonParse {
    public static void main(String[] args) {

        JsonPath js = new JsonPath(Payload.coursePrice());

        System.out.println("Response - " + "\n" + Payload.coursePrice());
//Print No of courses returned by API
        int numberOfCourses = js.getInt("courses.size()");
        System.out.println("Print No of courses returned by API - " + numberOfCourses);

        //Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Print Purchase Amount - " + purchaseAmount);

        //Print Title of the first course

        String titleOfFirstCourse = js.getString("courses[0].title");
        System.out.println("Print Title of the first course - " + titleOfFirstCourse);
//Print All course titles and their respective Prices
        System.out.println("Print All course titles and their respective Prices");
        for (int i = 0; i < numberOfCourses; i++) {
            titleOfFirstCourse = js.getString("courses[" + i + "].title");

            System.out.println("titleOfCourse - " + i + " position - " + titleOfFirstCourse + " And Price is " + js.getString("courses[" + i + "].price"));
        }
//Print no of copies sold by RPA Courses

        System.out.println("Print no of copies sold by RPA Courses");
        for (int i = 0; i < numberOfCourses; i++) {
            titleOfFirstCourse = js.getString("courses[" + i + "].title");
            if (titleOfFirstCourse.equalsIgnoreCase("RPA")) {
                System.out.println("titleOfCourse - " + i + " position - " + titleOfFirstCourse + " copies sold = " + js.getString("courses[" + i + "].copies"));
            break;
            }
        }

        //Verify if Sum of all Course prices matches with Purchase Amount
        System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
        int sum=0;
        for (int i = 0; i < numberOfCourses; i++) {

            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int amount = price*copies;
            System.out.printf("\n"+"amount - "+amount);
            sum=sum+amount;
            //System.out.println("titleOfCourse - " + i + " position - " + titleOfFirstCourse + " And Price is " + js.getString("courses[" + i + "].price"));
        }
        System.out.println("\n"+"Total sum = "+sum);
        Assert.assertEquals(sum,purchaseAmount);
        System.out.println("Total sum = "+sum);
    }
}
