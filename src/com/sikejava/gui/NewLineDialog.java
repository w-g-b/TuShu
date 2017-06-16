package com.sikejava.gui;

import com.sikejava.util.AllocationId;
import com.sikejava.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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


        JButton button_1 = new JButton("\u53D6\u6D88");
        button_1.setBounds(29, 116, 66, 23);
        contentPanel.add(button_1);

        JLabel label_1 = new JLabel("* \u7EBF\u8DEF\u5DF2\u5B58\u5728");
        label_1.setForeground(new Color(255, 99, 71));
        label_1.setBounds(86, 79, 85, 15);
        label_1.setVisible(false);
        contentPanel.add(label_1);
        (textField.getDocument()).addDocumentListener(new DocumentListener() {
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
                int line = Query.getIdByName(textField.getText());
                if (line != 0) {
                    label_1.setVisible(true);
                } else {
                    label_1.setVisible(false);
                }
            }
        });
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JButton button = new JButton("\u65B0\u5EFA");
        button.setBounds(105, 116, 66, 23);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lineName = textField.getText();
                int lineId = Query.getIdByName(lineName);
                if (lineId != 0) {
                    JOptionPane.showMessageDialog(NewLineDialog.this, "线路已存在", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!lineName.isEmpty() && !lineName.matches("[ ]+")) {
                    lineId = AllocationId.newId(0);
                    String lineIdStr = String.format("0x%08x", lineId);
                    String info = lineIdStr + " " + textField.getText() + " " + "0x00000000" + " " + "0x00000000";
                    Query.addInfo(info);
                    JOptionPane.showMessageDialog(NewLineDialog.this, "新建成功", "保存", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        contentPanel.add(button);
    }

}
