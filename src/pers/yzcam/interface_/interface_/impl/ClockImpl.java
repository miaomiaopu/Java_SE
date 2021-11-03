package pers.yzcam.interface_.interface_.impl;

import pers.yzcam.interface_.interface_.Clock;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 此类继承了 JFrame 并实现了 Computer 接口
 *
 * @author yzcam
 */
public class ClockImpl extends JFrame implements Clock {
    // 窗体标题
    private String title;
    // 按钮
    private JButton jButton;
    // 文本框
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    // 实例对象本身
    private ClockImpl self;

    /**
     * 抽象方法的具体实现
     *
     * @param a 一个数
     * @param b 另外一个数
     * @return a * b
     */
    @Override
    public double count(double a, double b) {
        return a * b;
    }

    /**
     * 有参构造方法
     *
     * @param title 窗体标题
     */
    public ClockImpl(String title) {
        init(title);
    }

    /**
     * 初始化窗体
     */
    private void init(String title) {
        self = this;

        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(200, 100, 800, 600);

        this.setLayout(null);

        jButton = new JButton("请点击计算");
        jButton.setBounds(100, 100, 150, 30);
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double n = Double.parseDouble(jTextField1.getText());
                double m = Double.parseDouble(jTextField2.getText());

                double res = self.count(n, m);
                jTextField3.setText(String.valueOf(res));

                self.validate();
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
        this.add(jButton);

        jTextField1 = new JTextField();
        jTextField1.setBounds(100, 200, 200, 30);
        this.add(jTextField1);

        jTextField2 = new JTextField();
        jTextField2.setBounds(100, 300, 200, 30);
        this.add(jTextField2);

        jTextField3 = new JTextField();
        jTextField3.setBounds(100, 400, 200, 30);
        this.add(jTextField3);

        jTextField4 = new JTextField();
        jTextField4.setBounds(100, 500, 200, 30);
        this.add(jTextField4);

        self.showSystemDataTime();

        this.validate();
    }

    @Override
    public void showSystemDataTime() {
        while (true) {
            Date time = new Date();
            String timeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
            jTextField4.setText(timeString);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
