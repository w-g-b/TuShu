package com.gb.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.gb.object.SpecificShop;
import com.gb.util.Query;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JLabel;

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(9, 10, 165, 222);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u7AD9\u540D");
		label.setBounds(20, 21, 54, 15);
		panel_2.add(label);
		panel_2.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(9, 10, 165, 212);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5730\u94C1\u540D");
		lblNewLabel.setBounds(10, 10, 54, 15);
		panel_1.add(lblNewLabel);
		panel_1.setVisible(true);

		DefaultMutableTreeNode root=new DefaultMutableTreeNode("地铁");
		DefaultMutableTreeNode line1=new DefaultMutableTreeNode("1号线");
		DefaultMutableTreeNode shop=new DefaultMutableTreeNode(new SpecificShop("0x01010101 七天连锁酒店 0x01010100 800 95 好地方"));
		line1.add(shop);
		DefaultMutableTreeNode line2=new DefaultMutableTreeNode("2号线");
		DefaultMutableTreeNode line3=new DefaultMutableTreeNode("3号线");
		DefaultMutableTreeNode line4=new DefaultMutableTreeNode("4号线");
		root.add(line1);
		root.add(line2);
		root.add(line3);
		root.add(line4);
//		for(String str:query.getIdByName("1"))
		JTree tree = new JTree(root);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node
				=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node.getUserObject().equals("1号线")){
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
