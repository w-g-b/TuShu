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
        label.setBounds(44, 54, 42, 15);
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
                    JOptionPane.showMessageDialog(NewLineDialog.this, "保存成功", "保存", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        button.setBounds(105, 116, 57, 23);
        contentPanel.add(button);

        JButton button_1 = new JButton("\u53D6\u6D88");
        button_1.setBounds(38, 116, 57, 23);
        contentPanel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }

}
