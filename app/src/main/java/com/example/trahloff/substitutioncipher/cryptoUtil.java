package com.example.trahloff.substitutioncipher;

/**
 * Created by trahloff on 28.11.17.
 */

class cryptoUtil {

    protected static String cipher(String input, String key, Boolean encrypt) {
        String output = "";
        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            output = output + (encrypt ?
                    key.charAt(((int) c) - 65) :
                    (char) (key.indexOf(c) + 65)
            );
        }
        return output;
    }

}
