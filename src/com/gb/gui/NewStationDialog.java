package com.gb.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.gb.util.AllocationId;
import com.gb.util.Query;

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
	                    dispose();
	                }
	            }
	        });
	        button.setBounds(118, 162, 57, 23);
	        contentPanel.add(button);

	        JButton button_1 = new JButton("\u53D6\u6D88");
	        button_1.setBounds(29, 162, 57, 23);
	        contentPanel.add(button_1);
	        
	        JLabel label_1 = new JLabel("\u6240\u5C5E\u7EBF\u8DEF:");
	        label_1.setBounds(30, 85, 54, 15);
	        contentPanel.add(label_1);
	        
	        textField_1 = new JTextField();
	        textField_1.setBounds(96, 82, 66, 21);
	        contentPanel.add(textField_1);
	        textField_1.setColumns(10);
	        
	        JLabel label_2 = new JLabel("\u662F\u5426\u6362\u4E58:");
	        label_2.setBounds(32, 115, 54, 15);
	        contentPanel.add(label_2);
	        
	        textField_2 = new JTextField();
	        textField_2.setBounds(96, 112, 66, 21);
	        contentPanel.add(textField_2);
	        textField_2.setColumns(10);
	        button_1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();

	            }
	        });
	}

}
