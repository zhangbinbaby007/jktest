package com.hjjy.test;

import javax.swing.*;


//1.继承Thread类 

//2.重写run方法 

public class Worker extends Thread
{

	private JLabel la;
	private boolean isSleep = true;// 暂停标志
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

	// 指示线程是否修改标签上的内容

	public void changeState()
	{
		isSleep = !isSleep;
		bu1.setText("暂停");
	}

	public void stopState()
	{
		stop = !stop;
	}

	// 线程的运行，是从run方法开始执行

	// 当run方法执行完毕时,一个线程退出!

	public void run()
	{
		int count = 0;
		while (true)
		{
			if (stop)
			{
				if (!isSleep)
				{
					bu1.setText("开始");
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