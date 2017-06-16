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

public class NewStationDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;


    /**
     * Create the dialog.
     */
    public NewStationDialog(ModifyDialog modifyDialog, String s, boolean b) {
        super(modifyDialog, s, b);
        setBounds(500, 300, 226, 271);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("\u7AD9\u70B9\u540D:");
        label.setBounds(37, 51, 51, 15);
        contentPanel.add(label);

        textField = new JTextField();
        textField.setBounds(98, 48, 79, 21);
        contentPanel.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u65B0\u5EFA");
        button.setBounds(107, 176, 70, 23);
        contentPanel.add(button);

        JButton button_1 = new JButton("\u53D6\u6D88");
        button_1.setBounds(30, 176, 66, 23);
        contentPanel.add(button_1);

        JLabel label_1 = new JLabel("\u6240\u5C5E\u7EBF\u8DEF:");
        label_1.setBounds(30, 95, 66, 15);
        contentPanel.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(98, 92, 79, 21);
        contentPanel.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_2 = new JLabel("\u662F\u5426\u6362\u4E58:");
        label_2.setBounds(32, 137, 63, 15);
        contentPanel.add(label_2);

        textField_2 = new JTextField();
        textField_2.setBounds(98, 134, 79, 21);
        contentPanel.add(textField_2);
        textField_2.setColumns(10);

        JLabel label_3 = new JLabel("* \u7EBF\u8DEF\u4E0D\u5B58\u5728");
        label_3.setForeground(new Color(255, 99, 71));
        label_3.setBounds(98, 115, 79, 15);
        label_3.setVisible(false);
        contentPanel.add(label_3);
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
                int lineId = Query.getIdByName(textField_1.getText());
                if (lineId == 0 && !textField_1.getText().isEmpty()) {
                    label_3.setVisible(true);
                } else {
                    label_3.setVisible(false);
                }
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int lineId = Query.getIdByName(textField_1.getText());
                if (lineId == 0) {
                    JOptionPane.showMessageDialog(NewStationDialog.this, "线路不存在,无法保存", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String lineIdStr = String.format("0x%08x", lineId);
                String stationIdStr = String.format("0x%08x", AllocationId.newId(lineId));
                boolean isTranslate = textField_2.getText().equals("换乘") ? true : false;
                String info = stationIdStr + " " + textField.getText() + " " + lineIdStr + " " + isTranslate;
                Query.addInfo(info);
                JOptionPane.showMessageDialog(NewStationDialog.this, "新建成功", "保存", JOptionPane.INFORMATION_MESSAGE);
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
