package kaoshi;

import javax.swing.*;
import java.awt.*;

public class Problem8 extends JFrame {

    private void initFrame() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setSize(300, 300);                          //窗口大小
        this.setTitle("简单计算器");                  //窗口的名称
        this.setLocationRelativeTo(null);               //窗口在屏幕的位置 默认中央
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);    //设置单击窗口右上角后，程序的处理
        this.setLayout(null);                         //布局格式 默认
        JTextField jtf = this.topSurfacee();      //调用方法
        this.setVisible(true);                   //设置窗口是否可见  ！放在前面窗口无内容

    }

    private JTextField topSurfacee() {
        JPanel topPanel = new JPanel();         //建立面板
        topPanel.setBounds(130, 10, 150, 70);       //窗口的在屏幕的位置
        JTextField jtf = new JTextField(10);    //显示结果文本框长度15个字
        jtf.setBounds(130, 10, 150, 100);
        jtf.setHorizontalAlignment(JTextField.RIGHT);// 设置文件右边往左边输出
        jtf.setForeground(Color.red);     //设置组件的前景色
        jtf.setFont(new Font("SansSerif", Font.PLAIN, 20)); //字体样式 字体格式 字体大小


        JPanel topPanel2 = new JPanel();         //建立面板
        topPanel2.setBounds(130, 80, 150, 70);       //窗口的在屏幕的位置
        JTextField jtf2 = new JTextField(10);    //显示结果文本框长度15个字
        jtf2.setBounds(130, 80, 150, 70);
        jtf2.setHorizontalAlignment(JTextField.RIGHT);// 设置文件右边往左边输出
        jtf2.setForeground(Color.red);     //设置组件的前景色
        jtf2.setFont(new Font("SansSerif", Font.PLAIN, 20)); //字体样式 字体格式 字体大小


        JPanel topPanel3 = new JPanel();         //建立面板
        topPanel3.setBounds(130, 150, 150, 50);       //窗口的在屏幕的位置
        JTextField jtf3 = new JTextField(10);    //显示结果文本框长度15个字
        topPanel3.setBounds(130, 150, 150, 50);
        jtf3.setHorizontalAlignment(JTextField.RIGHT);// 设置文件右边往左边输出
        jtf3.setForeground(Color.red);     //设置组件的前景色
        jtf3.setFont(new Font("SansSerif", Font.PLAIN, 20)); //字体样式 字体格式 字体大小
        jtf3.setEditable(false);

        topPanel.add(jtf);            //加入组件jtf
        topPanel2.add(jtf2);
        topPanel3.add(jtf3);

        JButton addButton = new JButton("Add");
        addButton.setBounds(0, 200, 130, 50);


        JPanel topPanel4 = new JPanel();         //建立面板
        topPanel4.setBounds(-40, 10, 170, 70);       //窗口的在屏幕的位置
        topPanel4.add(new Label("Number 1:", Label.LEFT));
        JPanel topPanel5 = new JPanel();         //建立面板
        topPanel5.setBounds(-40, 80, 170, 70);       //窗口的在屏幕的位置
        topPanel5.add(new Label("Number 2:", Label.LEFT));
        JPanel topPanel6 = new JPanel();         //建立面板
        topPanel6.setBounds(-65, 150, 195, 50);       //窗口的在屏幕的位置
        topPanel6.add(new Label("Sum:", Label.LEFT));

        this.add(topPanel);           //加入组件topPanel
        this.add(topPanel2);
        this.add(topPanel3);
        this.add(topPanel4);
        this.add(topPanel5);
        this.add(topPanel6);


        addButton.addActionListener(e -> {
                    int sum = Integer.valueOf(jtf.getText())+Integer.valueOf(jtf2.getText());
                    jtf3.setText(Integer.valueOf(sum).toString());

                }
        );


        this.add(addButton);


        return jtf;
    }


    public static void main(String[] args) {
        Problem8 calc = new Problem8();
        calc.initFrame();
    }

}
