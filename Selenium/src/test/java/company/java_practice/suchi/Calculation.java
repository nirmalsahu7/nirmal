package company.java_practice.suchi;

public class Calculation {

        int x, y, z;

        Calculation(int num1, int num2, int num3) {
            x = num1;
            y = num2;
            z = num3;
        }

        void sum() {
            System.out.println("Sum of three numbers is:" + (x + y + z));
        }

        public static void main(String[] args) {

            Calculation cal = new Calculation(10, 20, 30);
            cal.sum();
        }
        }

