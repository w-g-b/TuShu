package com.gb.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gb.util.Query;

import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	//public QueryDialog() {}
	public QueryDialog(JFrame f,String s,boolean b){
		super(f,s,b);
		setBounds(10, 39, 365, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(47, 29, 138, 25);
		contentPanel.add(splitPane);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7AD9\u70B9\u540D\u79F0:");
		label.setBounds(28, 83, 107, 15);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(157, 80, 87, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("\u9152\u5E97");
		checkBox.setBounds(74, 118, 60, 23);
		contentPanel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u8D85\u5E02");
		checkBox_1.setBounds(136, 118, 60, 23);
		contentPanel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\u7F8E\u98DF");
		checkBox_2.setBounds(198, 118, 54, 23);
		contentPanel.add(checkBox_2);
		
		JLabel label_1 = new JLabel("\u7C7B\u578B:");
		label_1.setBounds(28, 122, 54, 15);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u6761\u4EF6:");
		label_2.setBounds(28, 165, 54, 15);
		contentPanel.add(label_2);
		
		ButtonGroup conditionButon=new ButtonGroup();
		JRadioButton radioButton = new JRadioButton("\u6240\u6709");
		radioButton.setBounds(74, 161, 65, 23);
		contentPanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u8DDD\u79BB\u6700\u8FD1");
		radioButton_1.setBounds(136, 161, 87, 23);
		contentPanel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\u8BC4\u4EF7\u6700\u597D");
		radioButton_2.setBounds(74, 186, 121, 23);
		contentPanel.add(radioButton_2);
		
		conditionButon.add(radioButton);
		conditionButon.add(radioButton_1);
		conditionButon.add(radioButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 246, 263, 182);
		contentPanel.add(scrollPane);
		
		JTextArea txtrFdf = new JTextArea();
		txtrFdf.setEditable(false);
		scrollPane.setViewportView(txtrFdf);
		
		JButton button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrFdf.setText("");
				String stationName=textField.getText();
				int id=Query.getIdByName(stationName);
				//Query.getInfosByid(id);
				ArrayList<String>inforList=Query.getInfosByName(stationName);
				for(String info:inforList){
					txtrFdf.append(info+"\n");
				}
			}
		});
		button.setBounds(116, 213, 93, 23);
		contentPanel.add(button);
	
	}
}
