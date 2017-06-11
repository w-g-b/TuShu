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
	/**
	 * Create the dialog.
	 */
	public ModifyDialog(JFrame f, String s, boolean b) {
		super(f, s, b);
		query=new Query();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 10, 165, 222);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7EBF\u8DEF\u540D");
		lblNewLabel.setBounds(20, 10, 54, 15);
		panel_1.add(lblNewLabel);
		panel_1.setVisible(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 10, 165, 222);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u7AD9\u540D");
		label.setBounds(20, 21, 54, 15);
		panel_2.add(label);
		panel_2.setVisible(false);

		DefaultMutableTreeNode root=new DefaultMutableTreeNode("µØÌú");
		ArrayList<String> lineInfoList = query.getInfosMatchesId("0x.{2}000000");
		for (String lineInfo : lineInfoList) {
			Line line=new Line(lineInfo);
			DefaultMutableTreeNode lineNode = new DefaultMutableTreeNode(line);
			String lineIdStr = String.format("0x%08x", line.getId());
			ArrayList<String> StationInfoList = query.getInfosMatchesId(lineIdStr.substring(0, 4) + "(0[^0]|[^0]0)0000");
			for (String stationInfo : StationInfoList) {
				Station station = new Station(stationInfo);
				DefaultMutableTreeNode stationNode = new DefaultMutableTreeNode(station);
				String stationIdStr = String.format("0x%08x", station.getId());
				ArrayList<String> shopInfoList = query.getInfosMatchesId(stationIdStr.substring(0, 6) + ".{2}([0][^0]|[^0][0])");
				for (String shopInfo : shopInfoList) {
					SpecificShop shop = new SpecificShop(shopInfo);
					DefaultMutableTreeNode shopNode = new DefaultMutableTreeNode(shop);
					stationNode.add(shopNode);
				}
				lineNode.add(stationNode);
			}
			root.add(lineNode);
		}
//		for(String str:query.getIdByName("1"))
		JTree tree = new JTree(root);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node
				=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node.getUserObject().equals("1ºÅÏß")){
					panel_1.setVisible(true);
				}else {
					panel_1.setVisible(false);
					panel_2.setVisible(true);
				}
				
			}
		});
		scrollPane.setViewportView(tree);



	}
}
