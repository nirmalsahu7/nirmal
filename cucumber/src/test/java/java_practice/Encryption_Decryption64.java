package java_practice;

import java.util.Base64;

public class Encryption_Decryption64 {
    public static void main(String[] args) {
        String encrptData = "Sep2018#";

            byte[] encodedBytes = Base64.getEncoder().encode(encrptData.getBytes());
            System.out.println("encodedBytes --------------->" + new String(encodedBytes));

        String decrptData  ="U2VwMjAxOCM=";

        byte[] decodeBytes = Base64.getDecoder().decode(decrptData.getBytes());

        System.out.println("decodedBytes --------------->" + new String(decodeBytes));

        }
    }


