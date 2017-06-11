package com.gb.gui;

import com.gb.object.Line;
import com.gb.object.SpecificShop;
import com.gb.object.Station;
import com.gb.util.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

public class ModifyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Query query;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Create the dialog.
	 */
	public ModifyDialog(JFrame f, String s, boolean b) {
		super(f, s, b);
		query = new Query();
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setBounds(100, 100, 454, 289);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 438, 250);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(26, 10, 165, 212);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E97\u540D:");
		lblNewLabel_1.setBounds(10, 24, 54, 15);
		panel_3.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(74, 21, 66, 21);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7C7B\u578B:");
		label_5.setBounds(10, 65, 54, 15);
		panel_3.add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(74, 62, 66, 21);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_6 = new JLabel("\u9644\u8FD1\u5730\u94C1\u7AD9:");
		label_6.setBounds(10, 105, 75, 15);
		panel_3.add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setBounds(84, 102, 66, 21);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_7 = new JLabel("\u8DDD\u79BB:");
		label_7.setBounds(10, 136, 54, 15);
		panel_3.add(label_7);
		
		textField_9 = new JTextField();
		textField_9.setBounds(74, 133, 66, 21);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel label_8 = new JLabel("\u8BC4\u5206:");
		label_8.setBounds(10, 161, 54, 15);
		panel_3.add(label_8);
		
		textField_10 = new JTextField();
		textField_10.setBounds(74, 158, 66, 21);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_9 = new JLabel("\u8BC4\u4EF7:");
		label_9.setBounds(0, 186, 54, 15);
		panel_3.add(label_9);
		
		textField_11 = new JTextField();
		textField_11.setBounds(74, 183, 66, 21);
		panel_3.add(textField_11);
		textField_11.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 10, 165, 222);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		panel_2.setBounds(26, 10, 165, 222);

		JLabel label = new JLabel("\u7AD9\u540D:");
		label.setBounds(10, 30, 54, 15);
		panel_2.add(label);

		textField_3 = new JTextField();
		textField_3.setBounds(63, 27, 66, 21);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_3 = new JLabel("\u662F\u5426\u6362\u4E58:");
		label_3.setBounds(10, 76, 54, 15);
		panel_2.add(label_3);

		textField_4 = new JTextField();
		textField_4.setBounds(63, 73, 66, 21);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_4 = new JLabel("\u6240\u5C5E\u7EBF\u8DEF:");
		label_4.setBounds(10, 114, 54, 15);
		panel_2.add(label_4);

		textField_5 = new JTextField();
		textField_5.setBounds(73, 111, 66, 21);
		panel_2.add(textField_5);
		textField_5.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 10, 165, 222);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7EBF\u8DEF\u540D:");
		lblNewLabel.setBounds(10, 23, 54, 15);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(69, 20, 66, 21);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u8D77\u70B9\u7AD9:");
		label_1.setBounds(10, 73, 54, 15);
		panel_1.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(69, 70, 66, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u7EC8\u70B9\u7AD9:");
		label_2.setBounds(10, 121, 54, 15);
		panel_1.add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(69, 118, 66, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		panel_1.setVisible(true);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("µØÌú");
		ArrayList<String> lineInfoList = query.getInfosMatchesId("0x.{2}000000");
		for (String lineInfo : lineInfoList) {
			Line line = new Line(lineInfo);
			DefaultMutableTreeNode lineNode = new DefaultMutableTreeNode(line);
			String lineIdStr = String.format("0x%08x", line.getId());
			ArrayList<String> StationInfoList = query
					.getInfosMatchesId(lineIdStr.substring(0, 4) + "(0[^0]|[^0]0)0000");
			for (String stationInfo : StationInfoList) {
				Station station = new Station(stationInfo);
				DefaultMutableTreeNode stationNode = new DefaultMutableTreeNode(station);
				String stationIdStr = String.format("0x%08x", station.getId());
				ArrayList<String> shopInfoList = query
						.getInfosMatchesId(stationIdStr.substring(0, 6) + ".{2}([0][^0]|[^0][0])");
				for (String shopInfo : shopInfoList) {
					SpecificShop shop = new SpecificShop(shopInfo);
					DefaultMutableTreeNode shopNode = new DefaultMutableTreeNode(shop);
					stationNode.add(shopNode);
				}
				lineNode.add(stationNode);
			}
			root.add(lineNode);
		}
		// for(String str:query.getIdByName("1"))
		JTree tree = new JTree(root);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node.getUserObject() instanceof Line) {
					panel_1.setVisible(true);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
				} else if (node.getUserObject() instanceof Station) {
					panel_1.setVisible(false);
					panel_2.setVisible(true);
					panel_3.setVisible(false);
				} else if (node.getUserObject() instanceof SpecificShop) {
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel_3.setVisible(true);

				}

			}
		});
		scrollPane.setViewportView(tree);

	}
}
