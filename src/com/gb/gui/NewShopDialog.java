package com.gb.gui;

import com.gb.util.AllocationId;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setBounds(500, 300, 226, 383);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("\u5E97\u540D:");
        label.setBounds(31, 28, 42, 15);
        contentPanel.add(label);

        textField = new JTextField();
        textField.setBounds(83, 25, 66, 21);
        contentPanel.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u65B0\u5EFA");
        button.setBounds(112, 297, 66, 23);
        contentPanel.add(button);

        JButton button_1 = new JButton("\u53D6\u6D88");
        button_1.setBounds(19, 297, 66, 23);
        contentPanel.add(button_1);

        JLabel label_1 = new JLabel("\u7C7B\u578B:");
        label_1.setBounds(31, 61, 54, 15);
        contentPanel.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(83, 58, 66, 21);
        contentPanel.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_2 = new JLabel("\u9644\u8FD1\u7AD9\u70B9:");
        label_2.setBounds(19, 98, 54, 15);
        contentPanel.add(label_2);

        textField_2 = new JTextField();
        textField_2.setBounds(83, 95, 66, 21);
        contentPanel.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel label_3 = new JLabel("\u8DDD\u79BB:");
        label_3.setBounds(31, 129, 54, 15);
        contentPanel.add(label_3);
        
        textField_3 = new JTextField();
        textField_3.setBounds(83, 126, 66, 21);
        contentPanel.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel label_4 = new JLabel("\u8BC4\u5206:");
        label_4.setBounds(31, 161, 54, 15);
        contentPanel.add(label_4);
        
        textField_4 = new JTextField();
        textField_4.setBounds(83, 158, 66, 21);
        contentPanel.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel label_5 = new JLabel("\u8BC4\u4EF7:");
        label_5.setBounds(31, 187, 54, 15);
        contentPanel.add(label_5);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 212, 147, 75);
        contentPanel.add(scrollPane);
        
        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stationIdPref = String.format("%08x", Query.getIdByName(textField_2.getText())).substring(0, 4);
                // int shopTypeId = Query.getIdByName(textField_7.getText());
                // String shopTypeIdStr = String.format("0x%08x",
                // shop[0].getShopTypeId());
                String shopType = textField_1.getText();
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
                if (Query.getIdByName(textField_2.getText()) == 0) {
                    JOptionPane.showMessageDialog(NewShopDialog.this, "站点不存在", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String shopIdStrPref = stationIdPref + shopTypeIdStr + "00";
                String shopIdStr = String.format("0x%08x", AllocationId.newId(Integer.parseInt(shopIdStrPref, 16)));
                String info = shopIdStr + " " + textField.getText() + " 0x" + stationIdPref + shopTypeIdStr + "00 "
                        + textField_3.getText() + " " + textField_4.getText() + " " + textArea.getText();
                Query.addInfo(info);
                // JTree tree = new JTree(initTreeRoot());
                // scrollPane.setViewportView(tree);
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
