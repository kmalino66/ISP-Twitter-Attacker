package net.sdc.ispattack;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.TimerTask;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.SpeedTestSocket;
import fr.bmartel.speedtest.ISpeedTestListener;
import fr.bmartel.speedtest.SpeedTestError;

public class TestingThread extends TimerTask{

	private GuiMain master;
	
	public TestingThread(GuiMain master)
	{
		this.master = master;
		
	}

	@Override
	public void run() {
		
		if(master.isRunning())
		{
			try {
				long start = System.currentTimeMillis();
			 String fileName = "/files/test100Mb.db"; //The file that will be saved on your computer
			 URL link = new URL("http://speedtest.ftp.otenet.gr"); //The file that you want to download
			
	     //Code to download
			 InputStream in = new BufferedInputStream(link.openStream());
			 ByteArrayOutputStream out = new ByteArrayOutputStream();
			 byte[] buf = new byte[1024];
			 int n = 0;
			 while (-1!=(n=in.read(buf)))
			 {
			    out.write(buf, 0, n);
			 }
			 out.close();
			 in.close();
			 byte[] response = out.toByteArray();
			 long end = System.currentTimeMillis();
			 
			 long res = (end - start);
			 int ree = (int) (res / 1000);
			 System.out.println(ree);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}
	
}
