package java_practice;



// Java program for Method overloading

class MultiplyFun {

    // Method with 2 parameter
     int Multiply(int a, int b)
    {
        return a * b;
    }

    // Method with the same name but 2 double parameter
     double Multiply(double a, double b)
    {
        return a * b;
    }
}

class Main {
    public static void main(String[] args)
    {
        MultiplyFun mf=new MultiplyFun();


        //System.out.println(MultiplyFun.Multiply(2, 4));
        //System.out.println(MultiplyFun.Multiply(5.5, 6.3));

        System.out.println(mf.Multiply(2, 4));

        System.out.println(mf.Multiply(5.5, 6.3));
    }
}

