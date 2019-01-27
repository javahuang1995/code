package com.huang.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * �û��Զ�������������Ĭ�ϵĸ�������Ӧ����AppClassLoader
 * @author huang
 *
 */
public class DiskClassLoader extends ClassLoader {

	private String mLibPath;

	public DiskClassLoader(String path) {
		// TODO Auto-generated constructor stub
		mLibPath = path;
	}

	/**
	 * ���ļ�ת����InputStreamȻ��ת�����ֽ��롣Ȼ�����defineClass�������class.
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		String fileName = getFileName(name);

		File file = new File(mLibPath, fileName);

		try {
			FileInputStream is = new FileInputStream(file);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			try {
				while ((len = is.read()) != -1) {
					bos.write(len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] data = bos.toByteArray();
			is.close();
			bos.close();

			return defineClass(name, data, 0, data.length);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return super.findClass(name);
	}

	// ��ȡҪ���� ��class�ļ���
	//������com.huang.classloader.Test Ҫת����Test.class
	private String getFileName(String name) {
		// TODO Auto-generated method stub
		int index = name.lastIndexOf('.');
		if (index == -1) {
			return name + ".class";
		} else {
			return name.substring(index + 1) + ".class";
		}
	}

}
