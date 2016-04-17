package com.hjjy.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * 测试线程的中断，继续，中断，继续
 * @author Administrator
 */

public class User extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	{

		this.setTitle("测试线程");
		this.setLayout(new FlowLayout());
		this.setSize(100, 200);

		// 创建一个进度条对象

		JProgressBar jpa = new JProgressBar();
		jpa.setMaximum(600);// 设置最大度
		jpa.setValue(0);
		this.add(jpa);
		final JLabel la = new JLabel("显示区");
		this.add(la);
		JButton bu1 = new JButton("开始");
		this.add(bu1);
		JButton bu2 = new JButton("停止");
		this.add(bu2);
		this.setVisible(true);

		// 创建并启动后台线程:

		final Worker worker = new Worker(la, jpa, bu1, bu2);
		worker.start();

		bu1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// 按钮上的标签应改为停止 OK
				worker.changeState();
			}

		});

		bu2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				// 按钮上的标签应改为停止 OK
				worker.stopState();
			}
		});

	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args)
	{
		User u = new User();
		u.init();
	}

}