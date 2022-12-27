package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {

    public LoginJFrame() {
        // 设置窗口的大小
        this.setSize(488, 430);
        // 设置窗口的名称
        this.setTitle("游戏登录");
        // 设置窗口总是显示在屏幕最顶层
        this.setAlwaysOnTop(true);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
        // 设置窗口关闭方式 代表关闭一个窗口程序会停止
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置窗口的显示
        this.setVisible(true);
    }
}
