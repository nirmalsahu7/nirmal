package java_practice;

public class ForEachLoop {
    public static void main(String[] args) {

        // For loop
        int sum = 0;
        for(int j = 1; j<=10; j++) {
            sum = sum + j;
        }
        System.out.println("The sum of first 10 natural numbers is " + sum);

// for each loop
        String[] names = {"Java","C","C++","Python","JavaScript"};
        System.out.println("Printing the content of the array names:\n");
        for(String name:names) {
        System.out.println(name);
    }
}

}

