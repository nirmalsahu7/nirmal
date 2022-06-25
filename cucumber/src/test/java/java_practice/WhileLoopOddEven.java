package java_practice;

public class WhileLoopOddEven {
    public static void main(String[] args) {
        int i = 0;
       System.out.println("Printing the list of first odd or even numbers \n");
        while(i<=10) {
            //System.out.println(i);
           // i = i + 2;
            if(i%2==0)
            {
                System.out.println(i+ " is number even "+"\n");
            } else
            {
                System.out.println(i+ " is number odd "+"\n");
            }
            i++;
        }
    }
}

