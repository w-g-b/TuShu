package com.gb.gui;

import com.gb.util.AllocationId;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewLineDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;

    /**
     * Create the dialog.
     */
    public NewLineDialog(ModifyDialog modifyDialog, String s, boolean b) {
        super(modifyDialog, s, b);
        setBounds(500, 300, 226, 210);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("\u7EBF\u8DEF\u540D:");
        label.setBounds(39, 54, 57, 15);
        contentPanel.add(label);

        textField = new JTextField();
        textField.setBounds(96, 51, 66, 21);
        contentPanel.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u65B0\u5EFA");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lineName = textField.getText();
                if (!lineName.isEmpty() && !lineName.matches("[ ]+")) {
                    int lineId = AllocationId.newId(0);
                    String lineIdStr = String.format("0x%08x", lineId);
                    String info = lineIdStr + " " + textField.getText() + " " + "0x00000000" + " " + "0x00000000";
                    Query.addInfo(info);
                    JOptionPane.showMessageDialog(NewLineDialog.this, "�½��ɹ�", "����", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        button.setBounds(105, 116, 66, 23);
        contentPanel.add(button);

        JButton button_1 = new JButton("\u53D6\u6D88");
        button_1.setBounds(29, 116, 66, 23);
        contentPanel.add(button_1);
        
        JLabel label_1 = new JLabel("* \u7EBF\u8DEF\u5DF2\u5B58\u5728");
        label_1.setForeground(new Color(255, 99, 71));
        label_1.setBounds(86, 79, 85, 15);
        contentPanel.add(label_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }

}
