package company.java_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loops {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Practice Loops in java ...");
        System.out.println("1. for loop: When you know exactly how many times you want to loop through a block of code ...");
        for (int i=1;i<=5;i++)
        {
        System.out.println("Value of i -" +i);

        }
        System.out.println("2. for each loop: There is also a 'for-each' loop, which is used exclusively to loop through elements in an array ...");

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

//for each
        for (String i : cars) {
            System.out.println("string array : "+i);
        }

        int[] myNum= new int[]{1, 2, 3, 4};
        for (int j : myNum) {
            System.out.println("integer array : "+j);


        }
        for (int i=1;i<=5;i++)
        {
            System.out.println("Value of i -" +i);

            System.out.println("random number : "+i+"-"+(int)(Math.random()*10000001));
        }

    }
}
