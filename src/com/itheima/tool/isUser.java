package com.itheima.tool;

import com.itheima.domain.User;

import java.util.ArrayList;


public class isUser {
    static ArrayList<User> Users = new ArrayList<>();
    /*
    * 静态方法被该类的所有对象共享
    * 调用方式
    * 1.类名调用
    * 2.对象名调用*/

    public static boolean user(User userInput) {
        ArrayList<User> allUsers = allUsers();

        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if ((userInput.getUserName().equals(rightUser.getUserName())) && (userInput.getUserName().equals(rightUser.getUserName()))) {
                return true;
            }
        }
        return false;
    }

    // 初始化用户
    public static ArrayList<User> allUsers() {
        Users.add(new User("zhangSan", "123"));
        Users.add(new User("lisi", "1234"));
        return Users;
    }

    // 添加用户
    public static void addAllUsers(User info){
        Users.add(new User(info.getUserName(), info.getPassWord()));
    }
}
