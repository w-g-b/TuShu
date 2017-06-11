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
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	// public QueryDialog() {}
	public QueryDialog(JFrame f, String s, boolean b) {
		super(f, s, b);
		query = new Query();
		setBounds(500, 300, 365, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ButtonGroup buttonGroup = new ButtonGroup();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 38, 349, 408);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5E97\u540D:");
		lblNewLabel.setBounds(62, 41, 80, 15);
		panel_1.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(152, 38, 137, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 145, 263, 234);
		panel_1.add(scrollPane_1);

		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

		JButton button_1 = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button_1.setBounds(130, 99, 93, 23);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String shopName = textField_1.getText();
				ArrayList<String> infoList = query.getInfosByName(shopName);
				for (String info : infoList) {
					textArea.append(new SpecificShop(info).toShow());
				}
			}
		});
		panel_1.add(button_1);
		panel_1.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 349, 408);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7AD9\u70B9\u540D\u79F0:");
		label.setBounds(32, 55, 107, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(149, 52, 109, 21);
		panel.add(textField);
		textField.setColumns(10);

		JCheckBox checkBox = new JCheckBox("\u9152\u5E97");
		checkBox.setBounds(84, 98, 60, 23);
		panel.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("\u8D85\u5E02");
		checkBox_1.setBounds(160, 98, 60, 23);
		panel.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("\u7F8E\u98DF");
		checkBox_2.setBounds(236, 98, 54, 23);
		panel.add(checkBox_2);

		JLabel label_1 = new JLabel("\u7C7B\u578B:");
		label_1.setBounds(32, 102, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u6761\u4EF6:");
		label_2.setBounds(32, 144, 54, 15);
		panel.add(label_2);
		JRadioButton radioButton = new JRadioButton("\u6240\u6709");
		radioButton.setBounds(84, 140, 65, 23);
		panel.add(radioButton);

		buttonGroup.add(radioButton);
		radioButton.setSelected(true);

		JRadioButton radioButton_1 = new JRadioButton("\u8DDD\u79BB\u6700\u8FD1");
		radioButton_1.setBounds(236, 140, 87, 23);
		panel.add(radioButton_1);
		buttonGroup.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("\u8BC4\u4EF7\u6700\u597D");
		radioButton_2.setBounds(151, 140, 107, 23);
		panel.add(radioButton_2);
		buttonGroup.add(radioButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 216, 291, 182);
		panel.add(scrollPane);

		JTextArea txtrFdf = new JTextArea();
		scrollPane.setViewportView(txtrFdf);
		txtrFdf.setEditable(false);

		JButton button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button.setBounds(127, 183, 93, 23);
		panel.add(button);
		panel.setVisible(true);
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
				// Query3.getInfosByid(id);
				ArrayList<String> inforList = query.getShopInfosByStationId(id, shopType);// Query3.getInfosByName(stationName);
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

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 10, 138, 25);
		JButton button1 = new JButton("Õ¾µã");
		JButton button2 = new JButton("µêÃû");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(true);
				panel_1.setVisible(false);

			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel_1.setVisible(true);

			}
		});

		splitPane.add(button1, JSplitPane.LEFT, 1);
		splitPane.add(button2, JSplitPane.RIGHT, 2);
		contentPanel.add(splitPane);

	}
}
