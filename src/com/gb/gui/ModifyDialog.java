package com.gb.gui;

import com.gb.object.Line;
import com.gb.object.SpecificShop;
import com.gb.object.Station;
import com.gb.util.AllocationId;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(26, 60, 178, 222);
        panel.add(panel_2);
        panel_2.setLayout(null);
        panel_2.setVisible(false);

        JLabel label = new JLabel("\u7AD9\u540D:");
        label.setBounds(20, 26, 54, 15);
        panel_2.add(label);

        textField_3 = new JTextField();
        textField_3.setBounds(71, 23, 84, 21);
        panel_2.add(textField_3);
        textField_3.setColumns(10);

        JLabel label_3 = new JLabel("\u662F\u5426\u6362\u4E58:");
        label_3.setBounds(10, 109, 64, 18);
        panel_2.add(label_3);

        textField_4 = new JTextField();
        textField_4.setBounds(71, 64, 84, 21);
        panel_2.add(textField_4);
        textField_4.setColumns(10);

        JLabel label_4 = new JLabel("\u6240\u5C5E\u7EBF\u8DEF:");
        label_4.setBounds(10, 67, 64, 15);
        panel_2.add(label_4);

        textField_5 = new JTextField();
        textField_5.setBounds(71, 108, 84, 21);
        panel_2.add(textField_5);
        textField_5.setColumns(10);

        JButton button_1 = new JButton("\u4FDD\u5B58");
        button_1.setBounds(37, 149, 93, 23);
        panel_2.add(button_1);

        JLabel label_12 = new JLabel("* \u7EBF\u8DEF\u4E0D\u5B58\u5728");
        label_12.setForeground(new Color(255, 99, 71));
        label_12.setBounds(71, 90, 84, 15);
        label_12.setVisible(false);
        panel_2.add(label_12);
        panel_2.setVisible(false);


        JPanel panel_1 = new JPanel();
        panel_1.setBounds(26, 48, 178, 234);
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

        JLabel label_10 = new JLabel("* \u8BE5\u7EBF\u8DEF\u4E0D\u5B58\u5728\u6B64\u7AD9\u70B9");
        label_10.setForeground(new Color(255, 99, 71));
        label_10.setBounds(29, 100, 126, 15);
        label_10.setVisible(false);
        panel_1.add(label_10);

        JLabel label_11 = new JLabel("* \u8BE5\u7EBF\u8DEF\u4E0D\u5B58\u5728\u6B64\u7AD9\u70B9");
        label_11.setForeground(new Color(255, 99, 71));
        label_11.setBounds(29, 142, 126, 15);
        label_11.setVisible(false);
        panel_1.add(label_11);
        panel_1.setVisible(false);

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
        textArea.setLineWrap(true);
        scrollPane_1.setViewportView(textArea);
        panel_3.setVisible(false);

        // DefaultMutableTreeNode root = initTreeRoot();
        // for(String str:query.getIdByName("1"))
        JTree tree = new JTree(initTreeRoot());
        final Line[] line = {null};
        final Station[] station = {null};
        final SpecificShop[] shop = {null};
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
                    line[0] = (Line) nodeObject;
                    textField.setText(line[0].getName());
                    textField_1.setText(line[0].getFirstStationName());
                    textField_2.setText(line[0].getFinallyStationName());
                } else if (nodeObject instanceof Station) {
                    textField_3.setText("");
                    textField_4.setText("");
                    textField_5.setText("");
                    panel_1.setVisible(false);
                    panel_2.setVisible(true);
                    panel_3.setVisible(false);
                    station[0] = (Station) nodeObject;
                    textField_3.setText(station[0].getName());
                    textField_4.setText(station[0].getLine().getName());
                    textField_5.setText(station[0].isTransfer() ? "换乘" : "不换乘");
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
                    shop[0] = (SpecificShop) nodeObject;
                    textField_6.setText(shop[0].getName());
                    String idStr = String.format("0x%08x", shop[0].getId());
                    if (idStr.matches("0x.{4}01.{2}")) {
                        textField_7.setText("酒店");
                    } else if (idStr.matches("0x.{4}02.{2}")) {
                        textField_7.setText("超市");

                    } else if (idStr.matches("0x.{4}03.{2}")) {
                        textField_7.setText("美食");

                    }
                    textField_8.setText(shop[0].getStation().getName());
                    textField_9.setText(shop[0].getDistanceToStation() + "");
                    textField_10.setText(shop[0].getRemarkGrade() + "");
                    textArea.setText(shop[0].getRemarkContent());

                }

            }
        });

        (textField_1.getDocument()).addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!(textField_1.getText().isEmpty())) {
                    ArrayList<String> firstStationIdList = Query.getIdBySameName(textField_1.getText());
                    if (firstStationIdList.size() != 0) {
                        boolean b = false;
                        for (String firstStationId : firstStationIdList) {
                            b = Query.isLineStation(line[0].getId(), Integer.parseInt(firstStationId, 16));
                            if (b) {
                                break;
                            }
                        }
                        if (b) {
                            label_11.setVisible(false);
                        } else {
                            label_11.setVisible(true);
                        }
                    } else {
                        label_11.setVisible(true);
                    }

                }
            }
        });
        (textField_2.getDocument()).addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!(textField_2.getText().isEmpty())) {
                    ArrayList<String> finallyStatinIdList = Query.getIdBySameName(textField_2.getText());
                    if (finallyStatinIdList.size() != 0) {
                        boolean b = false;
                        for (String finallyStationId : finallyStatinIdList) {
                            b = Query.isLineStation(line[0].getId(), Integer.parseInt(finallyStationId, 16));
                            if (b) {
                                break;
                            }
                        }
                        if (b) {
                            label_11.setVisible(false);
                        } else {
                            label_11.setVisible(true);
                        }
                    } else {
                        label_11.setVisible(true);
                    }

                }
            }
        });
        (textField_4.getDocument()).addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!(textField_4.getText().isEmpty())) {
                    int lineId = Query.getIdByName(textField_4.getText());
                    if (lineId == 0) {
                        label_12.setVisible(true);
                    } else {
                        label_12.setVisible(false);
                    }

                }
            }
        });
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 保存站点
                int lineId = Query.getIdByName(textField_4.getText());
                if (lineId == 0) {
                    JOptionPane.showMessageDialog(ModifyDialog.this, "线路不存在,无法保存", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String lineIdStr = String.format("0x%08x", lineId);
                String stationIdStr = String.format("0x%08x", AllocationId.newId(lineId));
                boolean isTranslate = textField_5.getText().equals("换乘") ? true : false;
                String info = stationIdStr + " " + textField_3.getText() + " "
                        + lineIdStr + " " + isTranslate;
                Query.modifyStationAllInfo(station[0].getId(), info);
                // System.out.println("保存站点");
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstStationId = Query.getIdByName(textField_1.getText());
                int finallyStationId = Query.getIdByName(textField_2.getText());
                if (!Query.isLineStation(line[0].getId(), firstStationId)
                        || !Query.isLineStation(line[0].getId(), finallyStationId)) {
                    JOptionPane.showMessageDialog(ModifyDialog.this, "站点信息错误,无法保存", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String firstStationIdStr = String.format("0x%08x", firstStationId);
                String finallyStationIdStr = String.format("0x%08x", finallyStationId);
                String lineInfo = String.format("0x%08x", line[0].getId()) + " " + textField.getText() + " "
                        + firstStationIdStr + " " + finallyStationIdStr;
                Query.modifyInfo(line[0].getId(), lineInfo);
                // System.out.println("保存线路");
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String stationInfo = String.format("0x%08x",
                // station.getId())+" "+text
                // int shopTypeId = Query.getIdByName(textField_7.getText());
                String shopTypeIdStr = String.format("0x%08x", shop[0].getShopTypeId());
                String shopIdStr = String.format("0x%08x", shop[0].getId());
                String info = shopIdStr + " " + textField_6.getText() + " " + shopTypeIdStr + " "
                        + textField_9.getText() + " " + textField_10.getText() + " " + textArea.getText();
                Query.modifyInfo(shop[0].getId(), info);
                // JTree tree = new JTree(initTreeRoot());
                // scrollPane.setViewportView(tree);

            }
        });
        scrollPane.setViewportView(tree);
    }

    private DefaultMutableTreeNode initTreeRoot() {
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
        return root;
    }
}
