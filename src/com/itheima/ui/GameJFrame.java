package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //定义存储图片位置的二维数组
    int[][] imageIndex = new int[4][4];

    public GameJFrame() {
        // 初始化窗口
        initJFrame();
        // 初始化菜单
        initJMenuBar();
        // 随机二维数组
        initArray();
        // 初始化图片
        initImage();
        // 设置窗口的显示
        this.setVisible(true);
    }

    private void initArray() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        // 打乱数组里的元素
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(0, arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        // 将打乱后的数组元素存到二维数组中
        for (int i = 0; i < arr.length; i++) {
            imageIndex[i / 4][i % 4] = arr[i];
        }
    }

    private void initImage() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int count = imageIndex[i][j];
                System.out.println(count);
                JLabel jl = new JLabel(new ImageIcon("image/girl/girl1/" + count + ".jpg"));
                // 设置边框
                jl.setBorder(new BevelBorder(1));
                jl.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                this.getContentPane().add(jl);
            }
        }
        JLabel bg = new JLabel(new ImageIcon("image/background.png"));
        bg.setBounds(40,40,508,560);
        this.getContentPane().add(bg);
    }

    private void initJFrame() {
        // 设置窗口的大小
        this.setSize(603, 680);
        // 设置窗口的名称
        this.setTitle("拼图小游戏 V1.0");
        // 设置窗口总是显示在屏幕最顶层
        this.setAlwaysOnTop(true);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
        // 设置窗口关闭方式 代表关闭一个窗口程序会停止
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 取消默认的居中方式，按照X,Y轴的形式来添加组件
        this.setLayout(null);
        // 给整个键盘添加监听事件
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        JMenuBar jmb = new JMenuBar();

        JMenu jm1 = new JMenu("功能");
        JMenu jm2 = new JMenu("关于我们");

        JMenuItem jmi1 = new JMenuItem("重新游戏");
        JMenuItem jmi2 = new JMenuItem("关闭游戏");
        JMenuItem jmi3 = new JMenuItem("退出游戏");

        JMenuItem jmi4 = new JMenuItem("公众号");

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);

        jm2.add(jmi4);

        jmb.add(jm1);
        jmb.add(jm2);

        this.setJMenuBar(jmb);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
