package com.itheima.ui;

import com.itheima.domain.User;
import com.itheima.tool.isUser;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RegisterJFrame extends JFrame implements MouseListener {

    JButton registerButton = new JButton();
    JButton resetButton = new JButton();
    JTextField inputUserNameField = new JTextField();
    JPasswordField inputPassWordField = new JPasswordField();
    JPasswordField repeatInputPassWordField = new JPasswordField();

    public RegisterJFrame() {
        // 初始化窗口
        initJFrame();
        initRegister();
        // 设置窗口的显示
        this.setVisible(true);
    }

    private void initJFrame() {
        // 设置窗口的大小
        this.setSize(488, 500);
        // 设置窗口的名称
        this.setTitle("游戏注册");
        // 设置窗口总是显示在屏幕最顶层
        this.setAlwaysOnTop(true);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
        // 设置窗口关闭方式 代表关闭一个窗口程序会停止
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 取消默认的居中方式，按照X,Y轴的形式来添加组件
        this.setLayout(null);
    }

    private void initRegister() {
        // 输入用户名框
        JLabel inputUserName = new JLabel();
        inputUserName.setIcon(new ImageIcon("image/register/注册用户名.png"));
        inputUserName.setBounds(80, 140, 79, 17);
        this.getContentPane().add(inputUserName);

        inputUserNameField.setBounds(170, 140, 150, 29);
        this.getContentPane().add(inputUserNameField);
        // 输入密码框
        JLabel inputPassWord = new JLabel();
        inputPassWord.setIcon(new ImageIcon("image/register/注册密码.png"));
        inputPassWord.setBounds(80, 190, 64, 16);
        this.getContentPane().add(inputPassWord);

        inputPassWordField.setBounds(170, 190, 150, 29);
        inputPassWordField.setEchoChar('*');
        this.getContentPane().add(inputPassWordField);
        // 再次输入密码框
        JLabel repeatInputPassWord = new JLabel();
        repeatInputPassWord.setIcon(new ImageIcon("image/register/再次输入密码.png"));
        repeatInputPassWord.setBounds(80, 240, 96, 17);
        this.getContentPane().add(repeatInputPassWord);

        repeatInputPassWordField.setBounds(170, 240, 150, 29);
        repeatInputPassWordField.setEchoChar('*');
        this.getContentPane().add(repeatInputPassWordField);
        // 注册按钮
        registerButton.setIcon(new ImageIcon("image/register/注册按钮.png"));
        // 去除按钮边框
        registerButton.setBorderPainted(false);
        // 去除按钮背景
        registerButton.setContentAreaFilled(false);
        registerButton.setBounds(100, 300, 128, 47);
        registerButton.addMouseListener(this);
        this.getContentPane().add(registerButton);
        // 重置按钮
        resetButton.setIcon(new ImageIcon("image/register/重置按钮.png"));
        // 去除按钮边框
        resetButton.setBorderPainted(false);
        // 去除按钮背景
        resetButton.setContentAreaFilled(false);
        resetButton.setBounds(250, 300, 128, 47);
        resetButton.addMouseListener(this);
        this.getContentPane().add(resetButton);
        // 背景图片
        JLabel registerLabel = new JLabel(new ImageIcon("image/register/background.png"));
        registerLabel.setBounds(2, 20, 470, 390);
        this.getContentPane().add(registerLabel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == registerButton) {
            String userName = inputUserNameField.getText();
            String passWord = inputPassWordField.getText();
            String repeatPassWord = repeatInputPassWordField.getText();
            User userinfo = new User(userName, passWord);
            // 判断用户名是否存在
            if (isUser.user(userinfo)) {
                System.out.println("用户名已存在");
            } else {
                if (passWord.equals(repeatPassWord)) {

                    this.setVisible(false);
                    new LoginJFrame();
                }
            }
            System.out.println(userName + " " + passWord + " " + repeatPassWord);
        } else if (e.getSource() == resetButton) {
            System.out.println("111");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == registerButton) {
            registerButton.setIcon(new ImageIcon("image/register/注册按下.png"));
        } else if (e.getSource() == resetButton) {
            resetButton.setIcon(new ImageIcon("image/register/重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == registerButton) {
            registerButton.setIcon(new ImageIcon("image/register/注册按钮.png"));
        } else if (e.getSource() == resetButton) {
            resetButton.setIcon(new ImageIcon("image/register/重置按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
