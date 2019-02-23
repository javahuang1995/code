package rabbitmq.test3;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 实际上，RabbitMQ中消息传递模型的核心思想是：生产者不直接发送消息到队列。实际的运行环境中，生产者是不知道消息会发送到那个队列上，
 * 她只会将消息发送到一个交换器，交换器也像一个生产线，她一边接收生产者发来的消息，另外一边则根据交换规则，将消息放到队列中。
 * 交换器必须知道她所接收的消息是什么？它应该被放到那个队列中？它应该被添加到多个队列吗？还是应该丢弃？这些规则都是按照交换器的规则来确定的。 
 * 这个类会发送消息给交换机，然后RLog1和RLog2是一样的，都是获取一个队列，然后绑定到这个交换机上面，所以RLOG1和RLOG2都会受到所有消息。
 * @author huang
 * 这地方，发送给交换机，有个问题，EmitLog发送完毕后，没有Ack机制。
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

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");//定义一个交换器exchange

//      分发消息
        for(int i = 0 ; i < 5; i++){
            String message = "Hello World! " + i;
             channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
             System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
