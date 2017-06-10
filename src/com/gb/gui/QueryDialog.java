package com.gb.gui;

import com.gb.object.SpecificShop;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QueryDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private Query query;

    /**
     * Launch the application.
     */
    /**
     * Create the dialog.
     */
    //public QueryDialog() {}
    public QueryDialog(JFrame f, String s, boolean b) {
        super(f, s, b);
        query = new Query();
        setBounds(500, 300, 365, 485);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setBounds(47, 29, 138, 25);
        contentPanel.add(splitPane);

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7AD9\u70B9\u540D\u79F0:");
        label.setBounds(28, 83, 107, 15);
        contentPanel.add(label);

        textField = new JTextField();
        textField.setBounds(157, 80, 87, 21);
        contentPanel.add(textField);
        textField.setColumns(10);

        JCheckBox checkBox = new JCheckBox("\u9152\u5E97");
        checkBox.setBounds(74, 118, 60, 23);
        contentPanel.add(checkBox);

        JCheckBox checkBox_1 = new JCheckBox("\u8D85\u5E02");
        checkBox_1.setBounds(136, 118, 60, 23);
        contentPanel.add(checkBox_1);

        JCheckBox checkBox_2 = new JCheckBox("\u7F8E\u98DF");
        checkBox_2.setBounds(198, 118, 54, 23);
        contentPanel.add(checkBox_2);

        JLabel label_1 = new JLabel("\u7C7B\u578B:");
        label_1.setBounds(28, 122, 54, 15);
        contentPanel.add(label_1);

        JLabel label_2 = new JLabel("\u6761\u4EF6:");
        label_2.setBounds(28, 165, 54, 15);
        contentPanel.add(label_2);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton("\u6240\u6709");
        radioButton.setBounds(74, 161, 65, 23);
        contentPanel.add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("\u8DDD\u79BB\u6700\u8FD1");
        radioButton_1.setBounds(136, 161, 87, 23);
        contentPanel.add(radioButton_1);

        JRadioButton radioButton_2 = new JRadioButton("\u8BC4\u4EF7\u6700\u597D");
        radioButton_2.setBounds(74, 186, 121, 23);
        contentPanel.add(radioButton_2);

        buttonGroup.add(radioButton);
        buttonGroup.add(radioButton_1);
        buttonGroup.add(radioButton_2);
        radioButton.setSelected(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 246, 263, 182);
        contentPanel.add(scrollPane);

        JTextArea txtrFdf = new JTextArea();
        txtrFdf.setEditable(false);
        scrollPane.setViewportView(txtrFdf);

        JButton button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String shopType = "(";
                if (checkBox.isSelected()) {
                    shopType += "[0][1]|";
                }
                if (checkBox_1.isSelected()) {
                    shopType += "[0][2]|";
                }
                if (checkBox_2.isSelected()) {
                    shopType += "[0][3]|";
                }
                shopType += "[0][0])";
                txtrFdf.setText("");
                String stationName = textField.getText();
                int id = query.getStationIdByName(stationName);
                //Query3.getInfosByid(id);
                ArrayList<String> inforList = query.getShopInfosByStationId(id, shopType);//Query3.getInfosByName(stationName);
                SpecificShop shops[] = new SpecificShop[inforList.size()];
                int i = 0;
                for (String info : inforList) {
                    shops[i] = new SpecificShop(info);
                    i++;
                }
                if (radioButton.isSelected()) {
                    for (SpecificShop shop : shops) {
                        txtrFdf.append(shop.toShow());
                    }
                }
                if (radioButton_1.isSelected()) {
                    SpecificShop shop = shops[0];
                    for (int j = 1; j < shops.length; j++) {
                        if (shop.getDistanceToStation() > shops[j].getDistanceToStation()) {
                            shop = shops[j];
                        }
                    }
                    txtrFdf.append(shop.toShow());
                }
                if (radioButton_2.isSelected()) {
                    SpecificShop shop = shops[0];
                    for (int j = 1; j < shops.length; j++) {
                        if (shop.getRemarkGrade() < shops[j].getRemarkGrade()) {
                            shop = shops[j];
                        }
                    }
                    txtrFdf.append(shop.toShow());

                }
            }
        });
        button.setBounds(116, 213, 93, 23);
        contentPanel.add(button);

    }
}
