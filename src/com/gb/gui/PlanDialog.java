package com.gb.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PlanDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public PlanDialog(JFrame f, String s, boolean b) {
		super(f, s, b);
		setBounds(100, 100, 315, 445);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u8D77\u70B9\u7AD9:");
		label_1.setBounds(40, 59, 95, 22);
		contentPanel.add(label_1);

		textField = new JTextField();
		textField.setBounds(136, 60, 106, 21);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u7EC8\u70B9\u7AD9:");
		label_2.setBounds(40, 104, 95, 22);
		contentPanel.add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(136, 105, 106, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button.setBounds(101, 244, 93, 23);
		contentPanel.add(button);

		JLabel label = new JLabel("\u6761\u4EF6:");
		label.setBounds(58, 151, 54, 15);
		contentPanel.add(label);

		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton radioButton = new JRadioButton("\u6362\u4E58\u6B21\u6570\u6700\u5C11");
		radioButton.setBounds(107, 147, 121, 23);
		contentPanel.add(radioButton);
		buttonGroup.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\u8017\u65F6\u6700\u77ED");
		radioButton_1.setBounds(107, 176, 121, 23);
		contentPanel.add(radioButton_1);
		buttonGroup.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("\u7968\u4EF7\u6700\u5C11");
		radioButton_2.setBounds(107, 208, 121, 23);
		contentPanel.add(radioButton_2);
		buttonGroup.add(radioButton_2);
		radioButton.setSelected(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 277, 211, 105);
		contentPanel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
