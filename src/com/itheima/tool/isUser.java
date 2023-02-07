package com.itheima.tool;

import com.itheima.domain.User;

import java.util.ArrayList;


public class isUser {
    public static boolean user(User userInput) {
        ArrayList<User> allUsers = new ArrayList<>();
        // 初始化用户
        allUsers.add(new User("zhangSan", "123"));
        allUsers.add(new User("lisi", "1234"));

        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if ((userInput.getUserName().equals(rightUser.getUserName())) && (userInput.getUserName().equals(rightUser.getUserName()))) {
                return true;
            }
            // allUsers.add(new User(userInput.getUserName(), userInput.getPassWord()));
        }
        return false;
    }

}
