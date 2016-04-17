package com.hjjy.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * �����̵߳��жϣ��������жϣ�����
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

		this.setTitle("�����߳�");
		this.setLayout(new FlowLayout());
		this.setSize(100, 200);

		// ����һ������������

		JProgressBar jpa = new JProgressBar();
		jpa.setMaximum(600);// ��������
		jpa.setValue(0);
		this.add(jpa);
		final JLabel la = new JLabel("��ʾ��");
		this.add(la);
		JButton bu1 = new JButton("��ʼ");
		this.add(bu1);
		JButton bu2 = new JButton("ֹͣ");
		this.add(bu2);
		this.setVisible(true);

		// ������������̨�߳�:

		final Worker worker = new Worker(la, jpa, bu1, bu2);
		worker.start();

		bu1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// ��ť�ϵı�ǩӦ��Ϊֹͣ OK
				worker.changeState();
			}

		});

		bu2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				// ��ť�ϵı�ǩӦ��Ϊֹͣ OK
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