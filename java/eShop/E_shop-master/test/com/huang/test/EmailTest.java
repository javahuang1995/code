package com.huang.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * 我们只需要发送邮件就可以了，所以只需要用到SMTP
 * 设置一下smtp服务器，然后登陆上去就完事了。
 * @author huang
 *
 */
public class EmailTest {
	
	private static final String SMTPIP = "smtp.qq.com";
	private static final String USER = "1468435744@qq.com";
	private static final String PASS = "ilxarcvpkwdfffce";//这里填写授权码，而不是登陆密码。
	
	private static final String DEST="1468435744@qq.com";//发送给谁
	@Test
	public void mail() throws Exception{

        //1. 登陆邮件客户端(创建会话session)
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");    
        //创建了session会话
        Session session = Session.getDefaultInstance(prop);
        //设置debug模式来调试发送信息
        session.setDebug(true);
        
        
        //创建一封邮件对象
        Message message = new MimeMessage(session);
        //写信
        message.setSubject("主题什么的随便算了");
        //正文内容
        message.setContent("这是内容", "text/html;charset=utf-8");
        //附件人地址
        message.setFrom(new InternetAddress(USER));
        Transport transport = session.getTransport();
        //链接邮件服务器的认证信息
        transport.connect(SMTPIP, USER,PASS);
        // 设置收件人地址，并发送邮件
        transport.sendMessage(message, new InternetAddress[]{new InternetAddress(DEST)});
        transport.close();

	}
}
