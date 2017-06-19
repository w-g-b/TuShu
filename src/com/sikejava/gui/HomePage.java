package com.sikejava.gui;

import com.sikejava.MetroGraph.Paint;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setTitle("\u9014\u9F20");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 309, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton queryButton = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryDialog dialog = new QueryDialog(HomePage.this, "信息查询", true);
				dialog.setVisible(true);
			}
		});
		queryButton.setBounds(79, 89, 130, 23);
		contentPane.add(queryButton);

		JButton planButton = new JButton("\u7EBF\u8DEF\u89C4\u5212");
		planButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				com.sikejava.MetroGraph.Paint paint = new Paint();

			}
		});
		planButton.setBounds(79, 132, 130, 23);
		contentPane.add(planButton);

		JButton modifyButton = new JButton("\u540E\u53F0\u7BA1\u7406");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyDialog dialog = new ModifyDialog(HomePage.this, "修改信息", true);
				dialog.setVisible(true);
			}
		});
		modifyButton.setBounds(79, 177, 130, 23);
		contentPane.add(modifyButton);
	}
}
