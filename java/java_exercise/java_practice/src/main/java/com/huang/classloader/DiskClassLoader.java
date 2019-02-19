package com.huang.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 用户自定义的类加载器，默认的父加载器应该是AppClassLoader
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
	 * 把文件转换成InputStream然后转换成字节码。然后调用defineClass加载这个class.
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

	// 获取要加载 的class文件名
	//输入是com.huang.classloader.Test 要转换成Test.class
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
