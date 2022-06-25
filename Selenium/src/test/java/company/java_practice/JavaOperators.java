package company.java_practice;

public class JavaOperators {
    public static void main(String[] args) {
        int x=10;
        System.out.println("x=10 then x++ is : " + x++);//10 (11)
        //x=10;
        System.out.println("x=10 then ++x is : " + ++x);//12
      // x=10;
        System.out.println("x=10 then x--is : " + x--);//12 (11)
      // x=10;
        System.out.println("x=10 then --x is : " + --x);//10

/*        int a=10;
        int b=10;
        System.out.println(a++ + ++a);//10+12=22
        System.out.println(b++ + b++);//10+11=21*/

//Java Left Shift Operator Example
        System.out.println(10<<2);//10*2^2=10*4=40
        System.out.println(10<<3);//10*2^3=10*8=80
        System.out.println(20<<2);//20*2^2=20*4=80
        System.out.println(15<<4);//15*2^4=15*16=240

//Java Right Shift Operator Example
        System.out.println(10>>2);//10/2^2=10/4=2
        System.out.println(20>>2);//20/2^2=20/4=5
        System.out.println(20>>3);//20/2^3=20/8=2

//Java Ternary Operator Example
        int a=5;
        int b=2;
        int min=(a<b)?a:b;
        System.out.println("min is : " +min);

        /*
        Java AND Operator Example: Logical && and Bitwise &

The logical && operator doesn't check the second condition if the first condition is false. It checks the second condition only if the first one is true.

The bitwise & operator always checks both conditions whether first condition is true or false.
         */



    }
}
