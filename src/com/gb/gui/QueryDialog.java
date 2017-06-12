package com.gb.gui;

import com.gb.object.SpecificShop;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QueryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
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
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);

		JButton button_1 = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button_1.setBounds(130, 99, 93, 23);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String shopName = textField_1.getText();
				ArrayList<String> infoList = Query.getShopInfosByName(shopName);
				for (String info : infoList) {
					// TODO 存在问题，没有判断是否是店名
					textArea.append(new SpecificShop(info).toShow());
					textArea.setCaretPosition(0);
				}
			}
		});
		panel_1.add(button_1);

		JLabel label_5 = new JLabel("* \u5E97\u540D\u4E0D\u5B58\u5728");
		label_5.setForeground(new Color(255, 99, 71));
		label_5.setBounds(152, 69, 128, 15);
		label_5.setVisible(false);
		panel_1.add(label_5);
		panel_1.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 349, 408);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7AD9\u70B9\u540D\u79F0:");
		label.setBounds(32, 55, 107, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(137, 52, 109, 21);
		panel.add(textField);
		textField.setColumns(10);

		JCheckBox checkBox = new JCheckBox("\u9152\u5E97");

		checkBox.setBounds(79, 98, 60, 23);
		panel.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("\u8D85\u5E02");
		checkBox_1.setBounds(137, 98, 60, 23);
		panel.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("\u7F8E\u98DF");
		checkBox_2.setBounds(193, 98, 53, 23);
		panel.add(checkBox_2);

		JLabel label_1 = new JLabel("\u7C7B\u578B:");
		label_1.setBounds(32, 102, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u6761\u4EF6:");
		label_2.setBounds(32, 144, 54, 15);
		panel.add(label_2);
		JRadioButton radioButton = new JRadioButton("\u6240\u6709");
		radioButton.setBounds(79, 140, 65, 23);
		panel.add(radioButton);

		buttonGroup.add(radioButton);
		radioButton.setSelected(true);

		JRadioButton radioButton_1 = new JRadioButton("\u8DDD\u79BB\u6700\u8FD1");
		radioButton_1.setBounds(236, 140, 87, 23);
		panel.add(radioButton_1);
		buttonGroup.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("\u8BC4\u4EF7\u6700\u597D");
		radioButton_2.setBounds(153, 140, 81, 23);
		panel.add(radioButton_2);
		buttonGroup.add(radioButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 216, 291, 182);
		panel.add(scrollPane);

		JTextArea txtrFdf = new JTextArea();
		scrollPane.setViewportView(txtrFdf);
		txtrFdf.setEditable(false);
		// txtrFdf.setEnabled(false);
		txtrFdf.setLineWrap(true);

		JButton button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button.setBounds(127, 183, 93, 23);
		panel.add(button);

		JLabel label_3 = new JLabel("* \u7AD9\u70B9\u4E0D\u5B58\u5728");
		label_3.setForeground(new Color(255, 99, 71));
		label_3.setBounds(256, 55, 81, 15);
		label_3.setVisible(false);
		panel.add(label_3);

		JLabel label_4 = new JLabel("* \u8BF7\u52FE\u9009\u7C7B\u578B");
		label_4.setForeground(new Color(255, 99, 71));
		label_4.setBounds(256, 102, 81, 15);
		label_4.setVisible(false);
		panel.add(label_4);
		panel.setVisible(true);
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
				String str = textField.getText();
				int id = Query.getStationIdByName(str);
				if (id == 0 && !str.isEmpty()) {
					// panel.add(label);
					label_3.setVisible(true);
				} else {
					label_3.setVisible(false);
				}
			}
		});
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
				String str = textField_1.getText();
				ArrayList<String> infoList = Query.getShopIdsByName(str);
				if (infoList.size() == 0 && !str.isEmpty()) {
					// panel.add(label);
					label_5.setVisible(true);
				} else {
					label_5.setVisible(false);
				}
			}
		});
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					label_4.setVisible(false);
				}
			}
		});
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_1.isSelected()) {
					label_4.setVisible(false);
				}
			}
		});
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_2.isSelected()) {
					label_4.setVisible(false);
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkBox.isSelected() && !checkBox_1.isSelected() && !checkBox_2.isSelected()) {
					label_4.setVisible(true);
					if (textField.getText().isEmpty()) {
						label_3.setVisible(true);
					}
					return;
				}
				label_4.setVisible(false);
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
				int id = Query.getStationIdByName(stationName);
				// Query3.getInfosByid(id);
				ArrayList<String> inforList = Query.getShopInfosByStationId(id, shopType);// Query3.getInfosByName(stationName);
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
					ArrayList<SpecificShop> shopList = new ArrayList<>();
					SpecificShop shop = shops[0];
					shopList.add(shop);
					for (int j = 1; j < shops.length; j++) {
						// String idStr = String.format("0x%08x", shop.getId());
						// if (idStr.matches("0x.{6}" + shopType + ".{2}")) {
						if (shop.getDistanceToStation() > shops[j].getDistanceToStation()) {
							shopList.clear();
							shopList.add(shops[j]);
							shop = shops[j];
						} else if (shop.getDistanceToStation() == shops[j].getDistanceToStation()) {
							shopList.add(shops[j]);
						}
						// }
					}
					for (SpecificShop s : shopList) {
						txtrFdf.append(s.toShow());
					}
				}
				if (radioButton_2.isSelected()) {
					ArrayList<SpecificShop> shopList = new ArrayList<>();
					SpecificShop shop = shops[0];
					shopList.add(shop);
					for (int j = 1; j < shops.length; j++) {
						// String idStr = String.format("0x%08x", shop.getId());
						// if (idStr.matches("0x.{6}" + shopType + ".{2}")) {
						if (shop.getRemarkGrade() < shops[j].getRemarkGrade()) {
							shopList.clear();
							shopList.add(shops[j]);
							shop = shops[j];
						} else if (shop.getRemarkGrade() == shops[j].getRemarkGrade()) {
							shopList.add(shops[j]);
						}
						// }
					}
					for (SpecificShop s : shopList) {
						txtrFdf.append(s.toShow());
					}

				}
				txtrFdf.setCaretPosition(0);
			}
		});

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 10, 138, 25);
		JButton button1 = new JButton("站点");
		JButton button2 = new JButton("店名");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);

			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);

			}
		});

		splitPane.add(button1, JSplitPane.LEFT, 1);
		splitPane.add(button2, JSplitPane.RIGHT, 2);
		contentPanel.add(splitPane);

	}
}
