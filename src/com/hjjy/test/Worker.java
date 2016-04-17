package com.hjjy.test;

import javax.swing.*;


//1.�̳�Thread�� 

//2.��дrun���� 

public class Worker extends Thread
{

	private JLabel la;
	private boolean isSleep = true;// ��ͣ��־
	private JProgressBar jpa;
	private JButton bu1;
	private JButton bu2;
	private boolean stop = true;

	public Worker(JLabel la, JProgressBar jpa, JButton bu1,JButton bu2)
	{

		this.jpa = jpa;
		this.la = la;
		this.bu1 = bu1;
		this.bu2 = bu2;

	}

	// ָʾ�߳��Ƿ��޸ı�ǩ�ϵ�����

	public void changeState()
	{
		isSleep = !isSleep;
		bu1.setText("��ͣ");
	}

	public void stopState()
	{
		stop = !stop;
	}

	// �̵߳����У��Ǵ�run������ʼִ��

	// ��run����ִ�����ʱ,һ���߳��˳�!

	public void run()
	{
		int count = 0;
		while (true)
		{
			if (stop)
			{
				if (!isSleep)
				{
					bu1.setText("��ʼ");
					count += 10;
					jpa.setValue(count);
					String s = "" + count;
					la.setText(s);
				}

				try
				{
					Thread.sleep(100);
					if (count == 600)
					{
						break;
					}

				} catch (Exception ef)
				{

					ef.printStackTrace();

				}

			}

		}

	}

}