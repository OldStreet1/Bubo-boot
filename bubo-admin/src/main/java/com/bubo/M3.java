package com.bubo; /**
 * 避免方法2的混乱
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bubo.common.utils.StringUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;


import javax.swing.*;
public class M3{
    JFrame frame = new JFrame();
    JPanel jp1, jp2, jp3;//3个面板
    JLabel jlb1,jlb2;//两个标签
    JButton jb1,jb2;//两个按钮
    JTextField jtf1;//输入文本框
    JPasswordField jpf1;//输入密码框
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        new M3();
    }
    public M3(){
        //实例组件
        jp1 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("info");
        jb1 = new JButton("确认");


        jtf1 = new JTextField(10);
        jpf1 = new JPasswordField(10);

        //设置成网格布局
        frame.setLayout(new GridLayout(3,1));
        //加入组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp3.add(jb1);

        frame.add(jp1);
        frame.add(jp3);
        jb1.addActionListener(new Button1Handler());

        frame.setTitle("标题");
        frame.setSize(300, 150);
        frame.setLocation(250,250);
        //显示窗口true
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class Button1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
//            JOptionPane.showMessageDialog(frame,
//                    "按钮1 被点击");
//            System.out.println(jtf1.getText());
            dot dot = new dot();
            JSONObject jsonObject= JSONObject.parseObject(jtf1.getText());
            dot = JSON.toJavaObject(jsonObject,dot.class);
//            dot = jsonObject;
//            dot =(dot)JSONObject.parseObject(jsonObject).toJavaObject();
//            JSONArray.parseObject(jsonObject).toJavaObject(Xtxmb.
//            System.out.println(dot);
//            Object obj = JSONObject.parseObject(jtf1.getText(),Object.class);
//            Object parse = JSON.parse(jtf1.getText());
//            System.out.println(dot.getDatas());
//            JSONObject dataObj = jsonObject.getJSONObject("datas");
            if (dot != null){
                System.out.println(dot.getDatas());
                String res = JSON.toJSON(dot.getDatas()).toString();
                List<infodto> list = JSONArray.parseArray(res,infodto.class);//Chuku是实体类
                list.forEach(d->{
                    System.out.println(d.getHuji_qu());
                    try{
                        String data = " This content will append to the end of the file";
                        FileOutputStream o = null;
                        byte[] buff = new byte[]{};
                        File file = new File("/Users/street/data/project/Bubo-boot/bubo-admin/src/main/java/com/bubo/javaio.txt");
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        String str = "";
                        if (StringUtils.isNotEmpty(d.getName())){
                            str += d.getName()+"---";
                        }
                        if (StringUtils.isNotEmpty(d.getPid_y())){
                            str += d.getPid_y()+"---";
                        }
                        if (StringUtils.isNotEmpty(d.getLxfs())){
                            str += d.getLxfs()+"---";
                        }
                        if (StringUtils.isNotEmpty(d.getHuji_qu())){
                            str += d.getHuji_qu()+"---";
                        }
                        if (StringUtils.isNotEmpty(d.getXzz())){
                            str += d.getXzz()+"---";
                        }
                        str+="\r\n";
                        buff=str.getBytes();
                        o=new FileOutputStream(file,true);
                        o.write(buff);
                        o.flush();
                        o.close();

                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }



        }
    }

    private class Button2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(frame,
                    "按钮2 被点击");
        }
    }
}