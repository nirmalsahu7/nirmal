package java_practice;

class Show {
    int num = 150;
}

class Display extends Show {
    int num = 250;

    public void display(){
        System.out.println("num of subclass = " + num);
        System.out.println("num of super class = " + super.num);
    }
}

class DisplayChild extends Display {
    int num = 350;

    public void display(){
        System.out.println("num of subclass = " + num);
        System.out.println("num of super class = " + super.num);
    }
}
class Main2 {
    public static void main(String args[]){
        //create Show class object.
        Display obj = new Display();
        DisplayChild objchild = new DisplayChild();

        //method call
        obj.display();
        objchild.display();
    }
}
