package com.gb.gui;

import com.gb.object.Line;
import com.gb.object.SpecificShop;
import com.gb.object.Station;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;

    /**
     * Create the dialog.
     */
    public ModifyDialog(JFrame f, String s, boolean b) {
        super(f, s, b);
        setTitle("\u4FEE\u6539\u4FE1\u606F");
        setBounds(100, 100, 454, 416);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 438, 352);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane);
        JPanel panel = new JPanel();
        contentPanel.add(panel);
        panel.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(26, 10, 178, 322);
        panel.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("\u5E97\u540D:");
        lblNewLabel_1.setBounds(20, 24, 54, 15);
        panel_3.add(lblNewLabel_1);

        textField_6 = new JTextField();
        textField_6.setBounds(74, 21, 76, 21);
        panel_3.add(textField_6);
        textField_6.setColumns(10);

        JLabel label_5 = new JLabel("\u7C7B\u578B:");
        label_5.setBounds(20, 55, 54, 15);
        panel_3.add(label_5);

        textField_7 = new JTextField();
        textField_7.setBounds(74, 52, 76, 21);
        panel_3.add(textField_7);
        textField_7.setColumns(10);

        JLabel label_6 = new JLabel("\u9644\u8FD1\u7AD9\u70B9:");
        label_6.setBounds(10, 86, 75, 15);
        panel_3.add(label_6);

        textField_8 = new JTextField();
        textField_8.setBounds(74, 83, 76, 21);
        panel_3.add(textField_8);
        textField_8.setColumns(10);

        JLabel label_7 = new JLabel("\u8DDD\u79BB:");
        label_7.setBounds(20, 117, 54, 15);
        panel_3.add(label_7);

        textField_9 = new JTextField();
        textField_9.setBounds(74, 114, 76, 21);
        panel_3.add(textField_9);
        textField_9.setColumns(10);

        JLabel label_8 = new JLabel("\u8BC4\u5206:");
        label_8.setBounds(20, 148, 54, 15);
        panel_3.add(label_8);

        textField_10 = new JTextField();
        textField_10.setBounds(74, 145, 76, 21);
        panel_3.add(textField_10);
        textField_10.setColumns(10);

        JLabel label_9 = new JLabel("\u8BC4\u4EF7:");
        label_9.setBounds(20, 173, 54, 15);
        panel_3.add(label_9);

        JButton button = new JButton("\u4FDD\u5B58");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button.setBounds(40, 289, 93, 23);
        panel_3.add(button);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(20, 198, 140, 81);
        panel_3.add(scrollPane_1);

        JTextArea textArea = new JTextArea();
        scrollPane_1.setViewportView(textArea);
        panel_3.setVisible(false);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(26, 60, 178, 222);
        panel.add(panel_2);
        panel_2.setLayout(null);
        panel_2.setVisible(false);

        JLabel label = new JLabel("\u7AD9\u540D:");
        label.setBounds(20, 37, 54, 15);
        panel_2.add(label);

        textField_3 = new JTextField();
        textField_3.setBounds(71, 34, 84, 21);
        panel_2.add(textField_3);
        textField_3.setColumns(10);

        JLabel label_3 = new JLabel("\u662F\u5426\u6362\u4E58:");
        label_3.setBounds(10, 109, 54, 18);
        panel_2.add(label_3);

        textField_4 = new JTextField();
        textField_4.setBounds(71, 71, 84, 21);
        panel_2.add(textField_4);
        textField_4.setColumns(10);

        JLabel label_4 = new JLabel("\u6240\u5C5E\u7EBF\u8DEF:");
        label_4.setBounds(10, 74, 54, 15);
        panel_2.add(label_4);

        textField_5 = new JTextField();
        textField_5.setBounds(71, 108, 84, 21);
        panel_2.add(textField_5);
        textField_5.setColumns(10);

        JButton button_1 = new JButton("\u4FDD\u5B58");
        button_1.setBounds(37, 149, 93, 23);
        panel_2.add(button_1);
        panel_2.setVisible(false);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(26, 60, 178, 222);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u7EBF\u8DEF\u540D:");
        lblNewLabel.setBounds(10, 38, 54, 15);
        panel_1.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(69, 35, 86, 21);
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("\u8D77\u70B9\u7AD9:");
        label_1.setBounds(10, 79, 54, 15);
        panel_1.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(69, 76, 86, 21);
        panel_1.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_2 = new JLabel("\u7EC8\u70B9\u7AD9:");
        label_2.setBounds(10, 121, 54, 15);
        panel_1.add(label_2);

        textField_2 = new JTextField();
        textField_2.setBounds(69, 118, 86, 21);
        panel_1.add(textField_2);
        textField_2.setColumns(10);

        JButton button_2 = new JButton("\u4FDD\u5B58");
        button_2.setBounds(42, 164, 93, 23);
        panel_1.add(button_2);
        panel_1.setVisible(false);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("地铁");
        ArrayList<String> lineInfoList = Query.getInfosMatchesId("0x.{2}000000");
        for (String lineInfo : lineInfoList) {
            Line line = new Line(lineInfo);
            DefaultMutableTreeNode lineNode = new DefaultMutableTreeNode(line);
            String lineIdStr = String.format("0x%08x", line.getId());
            ArrayList<String> StationInfoList = Query
                    .getInfosMatchesId(lineIdStr.substring(0, 4) + "(0[^0]|[^0]0)0000");
            for (String stationInfo : StationInfoList) {
                Station station = new Station(stationInfo);
                DefaultMutableTreeNode stationNode = new DefaultMutableTreeNode(station);
                String stationIdStr = String.format("0x%08x", station.getId());
                ArrayList<String> shopInfoList = Query
                        .getInfosMatchesId(stationIdStr.substring(0, 6) + ".{2}([0][^0]|[^0][0])");
                for (String shopInfo : shopInfoList) {
                    SpecificShop shop = new SpecificShop(shopInfo);
                    DefaultMutableTreeNode shopNode = new DefaultMutableTreeNode(shop);
                    stationNode.add(shopNode);
                }
                lineNode.add(stationNode);
            }
            root.add(lineNode);
        }
        // for(String str:query.getIdByName("1"))
        JTree tree = new JTree(root);
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // TODO Auto-generated method stub
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                Object nodeObject = node.getUserObject();
                if (nodeObject instanceof Line) {
                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    panel_1.setVisible(true);
                    panel_2.setVisible(false);
                    panel_3.setVisible(false);
                    Line line = (Line) nodeObject;
                    textField.setText(line.getName());
                    textField_1.setText(line.getFirstStationName());
                    textField_2.setText(line.getFinallyStationName());
                    button_2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int firstStationId = Query.getIdByName(textField_1.getText());
                            int finallyStationId = Query.getIdByName(textField_2.getText());
                            String firstStationIdStr = String.format("0x%08x", firstStationId);
                            String finallyStationIdStr = String.format("0x%08x", finallyStationId);
                            String lineInfo = String.format("0x%08x", line.getId()) + " " + textField.getText() + " "
                                    + firstStationIdStr + " " + finallyStationIdStr;
                            Query.modifyInfo(line.getId(), lineInfo);
                            // System.out.println("保存线路");
                        }
                    });
                } else if (nodeObject instanceof Station) {
                    textField_3.setText("");
                    textField_4.setText("");
                    textField_5.setText("");
                    panel_1.setVisible(false);
                    panel_2.setVisible(true);
                    panel_3.setVisible(false);
                    Station station = (Station) nodeObject;
                    textField_3.setText(station.getName());
                    textField_4.setText(station.getLine().getName());
                    textField_5.setText(station.isTransfer() ? "换乘" : "不换乘");
                    button_1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // TODO 保存站点
                            int lineId = Query.getIdByName(textField_4.getText());
                            String lineIdStr = String.format("0x%08x", lineId);
                            boolean isTranslate = textField_5.getText().equals("换乘") ? true : false;
                            String info = String.format("0x%08x", station.getId()) + " " + textField_3.getText() + " "
                                    + lineIdStr + " " + " " + isTranslate;
                            Query.modifyInfo(station.getId(), info);
                            // System.out.println("保存站点");
                        }
                    });
                } else if (nodeObject instanceof SpecificShop) {
                    textField_6.setText("");
                    // textField_7.setText(shop.getName());
                    textField_8.setText("");
                    textField_9.setText("");
                    textField_10.setText("");
                    textArea.setText("");
                    panel_1.setVisible(false);
                    panel_2.setVisible(false);
                    panel_3.setVisible(true);
                    SpecificShop shop = (SpecificShop) nodeObject;
                    textField_6.setText(shop.getName());
                    String idStr = String.format("0x%08x", shop.getId());
                    if (idStr.matches("0x.{4}01.{2}")) {
                        textField_7.setText("酒店");
                    } else if (idStr.matches("0x.{4}02.{2}")) {
                        textField_7.setText("超市");

                    } else if (idStr.matches("0x.{4}02.{2}")) {
                        textField_7.setText("美食");

                    }
                    textField_8.setText(shop.getStation().getName());
                    textField_9.setText(shop.getDistanceToStation() + "");
                    textField_10.setText(shop.getRemarkGrade() + "");
                    textArea.setText(shop.getRemarkContent());
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // String stationInfo = String.format("0x%08x",
                            // station.getId())+" "+text
                            int shopTypeId = Query.getIdByName(textField_7.getText());
                            String shopTypeIdStr = String.format("0x%08x", shopTypeId);
                            String info = String.format("0x%08x", shop.getId()) + " " + textField_6.getText() + " "
                                    + shopTypeIdStr + " " + textField_9.getText() + " " + textField_10.getText() + " "
                                    + textArea.getText();
                            Query.modifyInfo(shop.getId(), info);

                        }
                    });

                }

            }
        });
        scrollPane.setViewportView(tree);

    }
}
