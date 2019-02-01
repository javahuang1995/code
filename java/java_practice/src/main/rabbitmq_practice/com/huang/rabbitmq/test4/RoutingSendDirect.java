package com.huang.rabbitmq.test4;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
 
/**
 * @author hushuang
 * 交换器的规则有：
direct （直连）
topic （主题）
headers （标题）
fanout （分发）也有翻译为扇出的。

 *
 */
public class RoutingSendDirect {
 
    private static final String EXCHANGE_NAME = "direct_logs";
    private final static String HOST = "192.168.0.104";

 // 路由关键字
 	private static final String[] routingKeys = new String[]{"info" ,"warning", "error"};
 	
    public static void main(String[] argv) throws Exception {
 
        ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//		声明交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");//这里的路由方式变了，成了direct
//		发送消息
        for(String severity :routingKeys){
        	String message = "Send the message level:" + severity;
        	channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());//发送三个消息，routtingkey分别是info,warning,error
        	System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
