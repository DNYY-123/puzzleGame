package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    // 定义存储图片位置的二维数组
    int[][] imageIndex = new int[4][4];
    int[][] win = new int[][]{
            {1, 5, 9, 13},
            {2, 6, 10, 14},
            {3, 7, 11, 15},
            {4, 8, 12, 0}
    };

    // 储存图片路径
    String[] imagePathArr = {"girl", "animal", "sport"};
    String imagePath = imagePathArr[new Random().nextInt(3)];
    int index = initImagePath();

    // x，y用来存储
    // 空格的位置
    int x = 0;
    int y = 0;
    // 定义游戏步数
    int step = 0;

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

    // 随机初始图片
    private int initImagePath() {
        int index = 0;
        Random r = new Random();
        switch (imagePath) {
            case "girl" -> index = r.nextInt(13) + 1;
            case "animal" -> index = r.nextInt(8) + 1;
            case "sport" -> index = r.nextInt(10) + 1;
        }
        return index;
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
            // 记录空白的位置
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
        }
    }

    private void initImage() {
        // 移除所有的内容
        this.getContentPane().removeAll();

        if (isWin()) {
            JLabel winJLabel = new JLabel(new ImageIcon("image/win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);


        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int count = imageIndex[i][j];
                JLabel jl = new JLabel(new ImageIcon("image/" + imagePath + "/" + imagePath + index + "/" + count + ".jpg"));
                // 设置边框
                jl.setBorder(new BevelBorder(1));
                jl.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                this.getContentPane().add(jl);
            }
        }
        JLabel bg = new JLabel(new ImageIcon("image/background.png"));
        bg.setBounds(40, 40, 508, 560);
        this.getContentPane().add(bg);

        this.getContentPane().repaint();
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

    // 菜单功能
    private void initJMenuBar() {
        JMenuBar jmb = new JMenuBar();

        JMenu jm1 = new JMenu("功能");
        JMenu jm2 = new JMenu("关于我们");

        JMenuItem jmi1 = new JMenuItem("重新游戏");
        jmi1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                step = 0;
                initArray();
                initImage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JMenu jm4 = new JMenu("更换图片");
        JMenuItem jmi41 = new JMenuItem("美女");
        jmi41.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                imagePath = imagePathArr[0];
                index = initImagePath();
                initArray();
                initImage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JMenuItem jmi42 = new JMenuItem("动物");
        jmi42.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                imagePath = imagePathArr[1];
                index = initImagePath();
                initArray();
                initImage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JMenuItem jmi43 = new JMenuItem("运动");
        jmi43.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                imagePath = imagePathArr[2];
                index = initImagePath();
                initArray();
                initImage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jm4.add(jmi41);
        jm4.add(jmi42);
        jm4.add(jmi43);

        JMenuItem jm5 = new JMenuItem("重新登录");
        jm5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setVisible(false);
                new LoginJFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JMenuItem jmi3 = new JMenuItem("退出游戏");
        jmi3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.exit(0);

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JMenuItem jmi4 = new JMenuItem("公众号");

        jm1.add(jm4);
        jm1.add(jm5);
        jm1.add(jmi1);
        jm1.add(jmi3);

        jm2.add(jmi4);

        jmb.add(jm1);
        jmb.add(jm2);

        this.setJMenuBar(jmb);
    }

    private boolean isWin() {
        for (int i = 0; i < imageIndex.length; i++) {
            for (int j = 0; j < imageIndex[i].length; j++) {
                if (imageIndex[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon("image/" + imagePath + "/" + imagePath + index + "/"+"all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            JLabel bg = new JLabel(new ImageIcon("image/background.png"));
            bg.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bg);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            if (x == 0) {
                return;
            }
            imageIndex[x][y] = imageIndex[x - 1][y];
            imageIndex[x - 1][y] = 0;
            System.out.println(imagePath);
            System.out.println(index);
            initImage();
            x--;
            step++;
            System.out.println("left");
        } else if (keyCode == 38) {
            if (y == 0) {
                return;
            }
            imageIndex[x][y] = imageIndex[x][y - 1];
            imageIndex[x][y - 1] = 0;
            y--;
            step++;
            initImage();
            System.out.println("up");
        } else if (keyCode == 39) {
            if (x == 3) {
                return;
            }
            imageIndex[x][y] = imageIndex[x + 1][y];
            imageIndex[x + 1][y] = 0;
            x++;
            step++;
            initImage();
            System.out.println("right");
        } else if (keyCode == 40) {
            if (y == 3) {
                return;
            }
            imageIndex[x][y] = imageIndex[x][y + 1];
            imageIndex[x][y + 1] = 0;
            y++;
            step++;
            initImage();
            System.out.println("down");
        } else if (keyCode == 65) {
            initImage();
        } else if (keyCode == 87) {
            imageIndex = new int[][]{
                    {1, 5, 9, 13},
                    {2, 6, 10, 14},
                    {3, 7, 11, 15},
                    {4, 8, 12, 0}
            };
            initImage();
            x = 3;
            y = 3;
        }
    }
}
