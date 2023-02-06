package com.itheima.tool;

import java.util.Random;

public class verificationCode {

    public static void main(String[] args) {
    }

    public static String code() {
        char[] letters = new char[62];
        for (int i = 0; i < letters.length; i++) {
            if (i < 26) {
                letters[i] = (char) (97 + i - 26);
            } else if (i < 52) {
                letters[i] = (char) (65 + i);
            } else {
                letters[i] = (char) (i - 4);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int num = r.nextInt(0, 62);
            sb.append(letters[num]);
        }
        return sb.toString();
    }
}
