package com.itheima.tool;

import java.util.Random;
// 生成随机5位的验证码
public class verificationCode {
    public static String code() {
        char[] letters = new char[62];
        for (int i = 0; i < letters.length; i++) {
            // 数字 48~57
            if (i < 10) {
                letters[i] = (char) (i + 48);
            }
            // 大写字母 65~90
            else if (i < 36) {
                letters[i] = (char) (i + 55);
            }
            // 小写字母 97~122
            else {
                letters[i] = (char) (i + 61);
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
