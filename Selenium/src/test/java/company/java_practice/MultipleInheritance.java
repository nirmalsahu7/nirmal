package company.java_practice;

interface DisplayAge{
    public void displayAge(int age);
}

interface DisplayName{
    //public void displayName(String name);
    public void displayName(String name);
}

class Test implements DisplayAge, DisplayName {

    @Override
    public void displayAge(int age) {
        System.out.println("Age = " + age);
    }

    @Override
    public void displayName(String name) {
        System.out.println("Name = " + name);
    }


        public static void main (String args[]){
        //object creation
        Test obj = new Test();

        //method call
        obj.displayName("Shivanshu");
        obj.displayAge(27);
    }
    }


