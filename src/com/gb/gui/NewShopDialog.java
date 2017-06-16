package com.gb.gui;

import com.gb.util.AllocationId;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewShopDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Create the dialog.
     */
    public NewShopDialog(ModifyDialog modifyDialog, String s, boolean b) {
        super(modifyDialog, s, b);
        setBounds(500, 300, 282, 383);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("\u5E97\u540D:");
        label.setBounds(61, 28, 42, 15);
        contentPanel.add(label);

        textField = new JTextField();
        textField.setBounds(113, 28, 76, 21);
        contentPanel.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u65B0\u5EFA");
        button.setBounds(153, 297, 66, 23);
        contentPanel.add(button);

        JButton button_1 = new JButton("\u53D6\u6D88");
        button_1.setBounds(49, 297, 66, 23);
        contentPanel.add(button_1);

        JLabel label_1 = new JLabel("\u7C7B\u578B:");
        label_1.setBounds(58, 66, 54, 15);
        contentPanel.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(113, 61, 76, 21);
        contentPanel.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_2 = new JLabel("\u9644\u8FD1\u7AD9\u70B9:");
        label_2.setBounds(46, 102, 71, 15);
        contentPanel.add(label_2);

        textField_2 = new JTextField();
        textField_2.setBounds(113, 98, 76, 21);
        contentPanel.add(textField_2);
        textField_2.setColumns(10);

        JLabel label_3 = new JLabel("\u8DDD\u79BB:");
        label_3.setBounds(61, 132, 54, 15);
        contentPanel.add(label_3);

        textField_3 = new JTextField();
        textField_3.setBounds(113, 129, 76, 21);
        contentPanel.add(textField_3);
        textField_3.setColumns(10);

        JLabel label_4 = new JLabel("\u8BC4\u5206:");
        label_4.setBounds(61, 164, 54, 15);
        contentPanel.add(label_4);

        textField_4 = new JTextField();
        textField_4.setBounds(113, 161, 76, 21);
        contentPanel.add(textField_4);
        textField_4.setColumns(10);

        JLabel label_5 = new JLabel("\u8BC4\u4EF7:");
        label_5.setBounds(61, 187, 54, 15);
        contentPanel.add(label_5);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(47, 212, 172, 74);
        contentPanel.add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JLabel label_6 = new JLabel("*");
        label_6.setForeground(new Color(255, 99, 71));
        label_6.setBounds(199, 64, 42, 15);
        label_6.setVisible(false);

        contentPanel.add(label_6);

        JLabel label_7 = new JLabel("*");
        label_7.setForeground(new Color(255, 99, 71));
        label_7.setBounds(199, 101, 42, 15);
        label_7.setVisible(false);
        contentPanel.add(label_7);
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
                String type = textField_1.getText();
                if (!type.equals("酒店") && !type.equals("美食") && !type.equals("超市")) {
                    label_6.setVisible(true);
                } else {
                    label_6.setVisible(false);
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
                int stationId = Query.getIdByName(textField_2.getText());
                if (stationId == 0 && !textField_2.getText().isEmpty()) {
                    label_7.setVisible(true);
                } else {
                    label_7.setVisible(false);
                }
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String shopType = textField_1.getText();
                if (!shopType.equals("酒店") && !shopType.equals("美食") && !shopType.equals("超市")) {
                    JOptionPane.showMessageDialog(NewShopDialog.this, "类型错误", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String shopTypeIdStr = null;
                if (shopType.equals("酒店")) {
                    shopTypeIdStr = "01";
                } else if (shopType.equals("超市")) {
                    shopTypeIdStr = "02";
                } else if (shopType.equals("美食")) {
                    shopTypeIdStr = "03";
                } else {
                    JOptionPane.showMessageDialog(NewShopDialog.this, "类型错误,无法保存", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                ArrayList<String> stationIds = Query.getStationIdsByName(textField_2.getText());
                if (stationIds.size() == 0) {
                    JOptionPane.showMessageDialog(NewShopDialog.this, "站点不存在", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for (String stationIdStr : stationIds) {
                    int stationId = Integer.parseInt(stationIdStr.substring(2), 16);

                    String stationIdPref = String.format("%08x", stationId).substring(0, 4);
                    String shopIdStrPref = stationIdPref + shopTypeIdStr + "00";
                    String shopIdStr = String.format("0x%08x", AllocationId.newId(Integer.parseInt(shopIdStrPref, 16)));
                    String info = shopIdStr + " " + textField.getText() + " 0x" + stationIdPref + shopTypeIdStr + "00 "
                            + textField_3.getText() + " " + textField_4.getText() + " " + textArea.getText();
                    Query.addInfo(info);
                    // JTree tree = new JTree(initTreeRoot());
                    // scrollPane.setViewportView(tree);
                }
                JOptionPane.showMessageDialog(NewShopDialog.this, "新建成功", "保存", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }

}
