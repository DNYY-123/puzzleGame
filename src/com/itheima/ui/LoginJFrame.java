package com.itheima.ui;

import com.itheima.domain.User;
import com.itheima.tool.verificationCode;
import com.itheima.tool.isUser;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    JButton loginJButton = new JButton();
    JButton registerJButton = new JButton();
    JTextField userNameJTextField = new JTextField();
    JPasswordField passwordJPasswordField = new JPasswordField();
    JTextField verificationCodeJTextField = new JTextField();
    String codes = verificationCode.code();

    public LoginJFrame() {
        initJFrame();
        initLogin();
        this.setVisible(true);
    }

    private void initLogin() {
        // 用户名
        JLabel userNameJLabel = new JLabel();
        userNameJLabel.setIcon(new ImageIcon("image/login/用户名.png"));
        userNameJLabel.setBounds(100, 130, 47, 17);
        this.getContentPane().add(userNameJLabel);
        userNameJTextField.setBounds(170, 130, 170, 29);
        this.getContentPane().add(userNameJTextField);

        // 密码
        JLabel passWordJLabel = new JLabel();
        passWordJLabel.setIcon(new ImageIcon("image/login/密码.png"));
        passWordJLabel.setBounds(112, 190, 32, 16);
        this.getContentPane().add(passWordJLabel);

        passwordJPasswordField.setBounds(170, 190, 150, 29);
        passwordJPasswordField.setEchoChar('*');
        this.getContentPane().add(passwordJPasswordField);

        JLabel showPassWordJLabel = new JLabel();
        showPassWordJLabel.setIcon(new ImageIcon("image/login/显示密码.png"));
        showPassWordJLabel.setBounds(320, 190, 20, 29);
        this.getContentPane().add(showPassWordJLabel);
        showPassWordJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                showPassWordJLabel.setIcon(new ImageIcon("image/login/显示密码按下.png"));
                passwordJPasswordField.setEchoChar('\0');
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPassWordJLabel.setIcon(new ImageIcon("image/login/显示密码.png"));
                passwordJPasswordField.setEchoChar('*');
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 验证码
        JLabel verificationCodeJLabel = new JLabel(new ImageIcon("image/login/验证码.png"));
        verificationCodeJLabel.setBounds(100, 250, 56, 21);
        this.getContentPane().add(verificationCodeJLabel);
        // 验证码框
        verificationCodeJTextField.setBounds(170, 250, 120, 29);
        this.getContentPane().add(verificationCodeJTextField);
        // 验证码字母
        JLabel verificationCode = new JLabel();
        verificationCode.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codes = com.itheima.tool.verificationCode.code();
                verificationCode.setText(codes);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        verificationCode.setText(codes);
        verificationCode.setBounds(300, 210, 100, 100);
        this.getContentPane().add(verificationCode);

        // 登录按钮
        loginJButton.setIcon(new ImageIcon("image/login/登录按钮.png"));
        // 去除按钮边框
        loginJButton.setBorderPainted(false);
        // 去除按钮背景
        loginJButton.setContentAreaFilled(false);
        loginJButton.setBounds(100, 300, 128, 47);
        loginJButton.addMouseListener(this);
        this.getContentPane().add(loginJButton);

        // 注册按钮
        registerJButton.setIcon(new ImageIcon("image/login/注册按钮.png"));
        // 去除按钮边框
        registerJButton.setBorderPainted(false);
        // 去除按钮背景
        registerJButton.setContentAreaFilled(false);
        registerJButton.setBounds(250, 300, 128, 47);
        registerJButton.addMouseListener(this);
        this.getContentPane().add(registerJButton);

        JLabel loginJLabel = new JLabel(new ImageIcon("image/login/background.png"));
        loginJLabel.setBounds(2, 0, 470, 390);
        this.getContentPane().add(loginJLabel);
    }

    private void initJFrame() {
        // 设置窗口的大小
        this.setSize(490, 430);
        // 设置窗口的名称
        this.setTitle("登陆界面");
        // 设置窗口总是显示在屏幕最顶层
        this.setAlwaysOnTop(true);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
        // 设置窗口关闭方式 代表关闭一个窗口程序会停止
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 取消默认的居中方式，按照X,Y轴的形式来添加组件
        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginJButton) {
            String inputUserName = userNameJTextField.getText();
            String inputPassWord = passwordJPasswordField.getText();
            String code = verificationCodeJTextField.getText();
            User userinfo = new User(inputUserName, inputPassWord);
            // 校验账号、密码和验证码
            if (isUser.user(userinfo) && codes.equalsIgnoreCase(code)) {
                System.out.println(inputUserName);
                System.out.println(inputPassWord);
                new GameJFrame();
                this.setVisible(false);
            } else {
                // 弹窗 owner:显示弹窗的窗体  title：标题  modal：true代表先关闭弹窗才可以对owner代表的窗体进行操作
                JDialog jd = new JDialog(this,"错误！！",true);
                jd.setSize(150, 100);
                jd.setAlwaysOnTop(true);
                jd.setLocationRelativeTo(null);
                jd.add(new JLabel("账号或者密码错误！！"));
                jd.setVisible(true);
            }
        } else if (e.getSource() == registerJButton) {
            new RegisterJFrame();
            this.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object a = e.getSource();
        if (e.getSource() == loginJButton) {
            loginJButton.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource() == registerJButton) {
            registerJButton.setIcon(new ImageIcon("image/login/注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == loginJButton) {
            loginJButton.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if (e.getSource() == registerJButton) {
            registerJButton.setIcon(new ImageIcon("image/login/注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
