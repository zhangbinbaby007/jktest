package com.hjjy.test;

import java.awt.event.*;

import javax.swing.*;


public class Tuz
{
	private JFrame fra;
	private JButton btn;

	public Tuz()
	{
		fra = new JFrame("f");
		btn = new JButton("btn");
		fra.add(btn);
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
//				fra.dispose();
				JFrame f1 = new JFrame("h");
				f1.setSize(300, 200);
				f1.setVisible(true);
				f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		fra.setSize(100, 100);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.addWindowListener(new WindowCloser());
	}
	private class WindowCloser extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		new Tuz();
	}
}