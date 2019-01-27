package com.huang.webservice.test;

import java.io.FileInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * �����ǻ���httpclient3 �ò����ײ��ҵ���ȷ��Pom.xml
 * @author huang
 *
 */
public class WebServiceTest {
	
	public static void main(String[] args) {
		String phone="18866885588";
		try {
			get(phone);
			post(phone);
			//soap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @Description get��ʽ����
	 * @param number
	 * @throws Exception
	 */
	public static void get(String number) throws Exception {
		 //HttpClient����java������ģ��Http����
	    // �������������
	    HttpClient client = new HttpClient();
	    // ��д���ݣ�����get����post����
	    GetMethod get = new GetMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx"
	            + "/getMobileCodeInfo?mobileCode=" + number + "&userID=");
	    // ָ������ĸ�ʽΪget�����ʽ
	    get.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
	    // ��������
	    int code = client.executeMethod(get);
	    System.out.println("Http:״̬��Ϊ��" + code);

	    String result = get.getResponseBodyAsString();
	    System.out.println("���صĽ��Ϊ��" + result);

	
	}

	/**
	 * @Description post��ʽ����
	 * @param number
	 * @throws Exception
	 */
	public static void post(String number) throws Exception {
		// HttpClient����java������ģ��Http����
		// �������������
		HttpClient client = new HttpClient();
		// ��д���ݣ�����get����post����
		PostMethod post = new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");

		// ָ������ĸ�ʽΪĬ��post��ʽ
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		// �������
		post.setParameter("mobileCode", number);
		post.setParameter("userID", "");

		// ��������
		int code = client.executeMethod(post);
		System.out.println("Http:״̬��Ϊ��" + code);

		String result = post.getResponseBodyAsString();
		System.out.println("���صĽ��Ϊ��" + result);
	}

	/**
	 * @Description soap post��ʽ���󣬵��Ǵ��������Ϊxml��ʽ�����������ݵ�ά��
	 * @param number
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static void soap() throws Exception {
		// HttpClient����java������ģ��Http����
		// �������������
		HttpClient client = new HttpClient();
		// ��д���ݣ�����get����post����
		PostMethod post = new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");

		// ָ������ĸ�ʽΪxml��ʽ
		post.setRequestHeader("Content-Type", "application/soap+xml;charset=utf-8");
		// ����xml������soap.txt
		post.setRequestBody(new FileInputStream("E:/github/client/src/soap.txt"));
		// ��������
		int code = client.executeMethod(post);
		System.out.println("Http:״̬��Ϊ��" + code);

		String result = post.getResponseBodyAsString();
		// ������õ���soap���򷵻ص�����Ҳ�ǻ���xml��soap��ʽ
		System.out.println("���صĽ��Ϊ��" + result);
	}

}
