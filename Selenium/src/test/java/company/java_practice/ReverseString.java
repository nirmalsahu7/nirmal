package company.java_practice;


public class ReverseString {
        public static void main (String[] args) {
            String str= "Geeks";
            String revStr= getReverseStringWithCharAtMethod(str);
            //System.out.println("Geeks"); //Example word
            System.out.println("Original word: " + str);
            System.out.println("Reverese word from getReverseStringWithCharAtMethod(): " + revStr);
            StringBuilder revStr2=getReverseStringWithStringBuilderMethod(str);
            System.out.println("Reverese word from getReverseStringWithCharAtMethod(): " + revStr2);

        }

        static String getReverseStringWithCharAtMethod(String str) {

            String revStr = "";
            char ch;


            System.out.println( "str.length():"+ str.length());
            //for (int i = 0; i < str.length(); i++) {
                for (int i = str.length()-1; i >= 0; i--) {
                ch = str.charAt(i); //extracts each character
                System.out.println(i +":"+ ch);
                revStr = revStr+ch; //adds each character in front of the existing string
            }
            System.out.println("Reversed word: " + revStr);
            return revStr;
        }

    static StringBuilder getReverseStringWithStringBuilderMethod(String str) {
        StringBuilder revStr = new StringBuilder();

        // append a string into StringBuilder input1
        revStr.append(str);

        // reverse StringBuilder input1
        revStr.reverse();

        // print reversed String
       // System.out.println("inside method-" +revStr);
        return revStr;
    }
    }

