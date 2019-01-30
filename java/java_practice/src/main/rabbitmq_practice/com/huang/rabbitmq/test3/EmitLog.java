package com.huang.rabbitmq.test3;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * ʵ���ϣ�RabbitMQ����Ϣ����ģ�͵ĺ���˼���ǣ������߲�ֱ�ӷ�����Ϣ�����С�ʵ�ʵ����л����У��������ǲ�֪����Ϣ�ᷢ�͵��Ǹ������ϣ�
 * ��ֻ�Ὣ��Ϣ���͵�һ����������������Ҳ��һ�������ߣ���һ�߽��������߷�������Ϣ������һ������ݽ������򣬽���Ϣ�ŵ������С�
 * ����������֪���������յ���Ϣ��ʲô����Ӧ�ñ��ŵ��Ǹ������У���Ӧ�ñ���ӵ���������𣿻���Ӧ�ö�������Щ�����ǰ��ս������Ĺ�����ȷ���ġ� 
 * �����ᷢ����Ϣ����������Ȼ��RLog1��RLog2��һ���ģ����ǻ�ȡһ�����У�Ȼ��󶨵�������������棬����RLOG1��RLOG2�����ܵ�������Ϣ��
 * @author huang
 * ��ط������͸����������и����⣬EmitLog������Ϻ�û��Ack���ơ�
 *
 */
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";
    private final static String HOST = "192.168.0.104";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

//      �ַ���Ϣ
        for(int i = 0 ; i < 5; i++){
            String message = "Hello World! " + i;
             channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
             System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
