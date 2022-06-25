
package java_practice;

// Java Program to Illustrate Working of
// Parameterized Constructor

// Importing required inputoutput classs


// Class 1
class ConstructorWithArgument {
    // data members of the class.
    String name;
    int id;

    // Constructor would initialize data members
    // With the values of passed arguments while
    // Object of that class created
    ConstructorWithArgument(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
}

// Class 2
class GFG2 {
    // main driver method
    public static void main(String[] args)
    {
        // This would invoke the parameterized constructor.
        ConstructorWithArgument geek1 = new ConstructorWithArgument("adam", 1);
        System.out.println("GeekName :" + geek1.name
                + " and GeekId :" + geek1.id);
    }
}