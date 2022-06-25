package java_practice;

public class ContructorWithoutArgument {

    int num;
    String name;

    // this would be invoked while an object
    // of that class is created.
    ContructorWithoutArgument()
    {
        System.out.println("Constructor called");
    }
}

class GFG
{
    public static void main (String[] args)
    {
        // this would invoke default constructor.
        ContructorWithoutArgument geek1 = new ContructorWithoutArgument();
        ContructorWithoutArgument geek2 = new ContructorWithoutArgument();

        // Default constructor provides the default
        // values to the object like 0, null
        System.out.println(geek1.name);
        System.out.println(geek1.num);
    }
}
