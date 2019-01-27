package com.huang.rabbitmq.test4;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
 
/**
 * @author hushuang
 * �������Ĺ����У�
direct ��ֱ����
topic �����⣩
headers �����⣩
fanout ���ַ���Ҳ�з���Ϊ�ȳ��ġ�

 *
 */
public class RoutingSendDirect {
 
    private static final String EXCHANGE_NAME = "direct_logs";
    private final static String HOST = "192.168.0.104";

 // ·�ɹؼ���
 	private static final String[] routingKeys = new String[]{"info" ,"warning", "error"};
 	
    public static void main(String[] argv) throws Exception {
 
        ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//		����������
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");//�����·�ɷ�ʽ���ˣ�����direct
//		������Ϣ
        for(String severity :routingKeys){
        	String message = "Send the message level:" + severity;
        	channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());//����������Ϣ��routtingkey�ֱ���info,warning,error
        	System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
