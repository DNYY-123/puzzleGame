package com.itheima.ui;

import javax.swing.*;

public class loginPopup extends JFrame {
    public loginPopup(){
        initLoginPopup();
        this.setVisible(true);
    }

    private void initLoginPopup(){
        // 设置窗口的大小
        this.setSize(300, 200);
        // 设置窗口的名称
        this.setTitle("错误！！");
        // 设置窗口总是显示在屏幕最顶层
        this.setAlwaysOnTop(true);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
        // 取消默认的居中方式，按照X,Y轴的形式来添加组件
        this.setLayout(null);
    }
}
