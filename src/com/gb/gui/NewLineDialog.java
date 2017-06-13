package com.gb.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewLineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public NewLineDialog(ModifyDialog modifyDialog, String s, boolean b) {
		super(modifyDialog,s,b);
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
			}
		});
		button.setBounds(105, 116, 57, 23);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(38, 116, 57, 23);
		contentPanel.add(button_1);
	}

}
