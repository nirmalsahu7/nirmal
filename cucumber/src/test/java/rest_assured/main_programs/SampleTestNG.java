package rest_assured.main_programs;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import supporting_files.Payload;

public class SampleTestNG {
    @Test
    public void sumOfCourses(){
        JsonPath js = new JsonPath(Payload.coursePrice());

        System.out.println("Response - " + "\n" + Payload.coursePrice());
        int numberOfCourses = js.getInt("courses.size()");
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
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
