package com.celestial.meek.realTest_2016_04_oldTest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class te {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		System.out.println("all in seat are garbage~");
//		String[] sArr={"11104"};
//		ClassDump.main(sArr); //能用 但是不知道dump出来把东西放哪儿了
		/*FileInputStream fi=new FileInputStream("D:/workspace/test/bin/te2.class");
		int n=fi.read();
		while((n=fi.read())>-1){
			System.out.println(n);
		}
		InputStream is;
		is.read();*/
//		te1();
		
		//te2();
		
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		
		
		
//		DBUtil.getConnection(
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	private static void te2()  throws Exception{
		int n;
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:/tat/t1.txt")));
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:/tat/t2.txt")));
		while((n=br.read())>-1){
			
			System.out.println(n);
			pw.print(n);
		}
		pw.flush();
		pw.close();
		br.close();
		
	}

	/**
	 * 生成class反码文件
	 * 
	 * @throws Exception
	 */
	private static void te1() throws Exception {
		int n=16;
		byte b[]=new byte[n];
		InputStream is=new FileInputStream("D:/tat/jvm的留存/MyLoader.class");
		int k=0;
		OutputStream os=new FileOutputStream("D:/tat/jvm的留存/MyLoader2.class");
		while((k=is.read(b, 0, n)) != -1){
			System.out.print(new String(b,0,k));
			for(int i=0;i<k;i++){
				b[i]=(byte)~b[i];
			}
			
			//System.out.println(new String(b,0,k));
			os.write(b, 0, k);
		}
		os.flush();
		os.close();
		is.close();
		
		
	}

}
