package com.example.trahloff.substitutioncipher;

/**
 * Created by trahloff on 28.11.17.
 */

class parserUtil {

    private static boolean hasOnlyUniqueChars(String key) {
        return key.matches("((.)(?!.*?\\2))*");
    }

    private static boolean isEnglish(String key) {
        boolean valid = true;
        char[] chars = key.toCharArray();
        for (char c : chars) {
            valid = ((c >= 'A') && (c <= 'Z'));
            if (!valid) break;
        }
        return valid;
    }

    protected static boolean isKeyValid(String key) {
        return (key.length() == 26 && hasOnlyUniqueChars(key) && isEnglish(key));
    }
}
