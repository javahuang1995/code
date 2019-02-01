package com.huang.main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class MainClass {
	
	public static void main(String[] args) {
		MainClass a= new MainClass();
		//a.maptest();
		//a.stream();
		//a.outputStream();
		//a.Reader();
		ListStudy.for1();
	}

	public void maptest(){
		Map<String,String>  aMap = new HashMap<String,String>();
		aMap.put("name","huangning");
		for(Map.Entry<String,String> entry: aMap.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
			StringBuffer keyValue = new StringBuffer();
			keyValue.append(key+":");
			keyValue.append(value);
			System.out.println(keyValue);
		}
	}
	public void stream(){
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			int count,n=512;
			byte[] buffer = new byte[n];//字节流需要用字节数组
			count = System.in.read(buffer);
			fos.write(buffer,0,count);
			fos.flush();
			System.out.println("写入成功");
			fos.close();
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			DataOutputStream dos = new DataOutputStream(bos);
//			dos.writeInt(3);
//			dos.writeBoolean(true);
//			dos.flush();
//			dos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void outputStream(){
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			int n =512;
			byte [] buffer = new byte[n];
			while(fis.read(buffer, 0, n)!=-1){
				System.out.println(new String(buffer));
			}
		} catch (Exception e) {
			
		}
	}
	public void Reader(){
		try {
			FileReader fr = new FileReader("test.txt"); 
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			while(null != (s=br.readLine())){
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}














