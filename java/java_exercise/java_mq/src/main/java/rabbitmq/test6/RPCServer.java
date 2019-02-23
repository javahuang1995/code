package rabbitmq.test6;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class RPCServer {

	private static final String RPC_QUEUE_NAME = "rpc_queue";
    private final static String HOST = "192.168.0.104";


    /**
     * 计算斐波那契数值
     * @param n
     * @return
     */
	private static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] argv) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(HOST);
			factory.setUsername("huang");
			factory.setPassword("1995");
			connection = factory.newConnection();
			channel = connection.createChannel();

			channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);

			channel.basicQos(1);

			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

			System.out.println("RPCServer [x] Awaiting RPC requests");

			while (true) {
				String response = null;

				QueueingConsumer.Delivery delivery = consumer.nextDelivery();

				BasicProperties props = delivery.getProperties();
				BasicProperties replyProps = new BasicProperties.Builder().correlationId(props.getCorrelationId()).build();

				try {
					String message = new String(delivery.getBody(), "UTF-8");
					int n = Integer.parseInt(message);

					System.out.println("RPCServer [.] fib(" + message + ")");
					response = "" + fib(n);
				} catch (Exception e) {
					System.out.println(" [.] " + e.toString());
					response = "";
				} finally {
					channel.basicPublish("", props.getReplyTo(), replyProps, response.getBytes("UTF-8"));

					channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception ignore) {
				}
			}
		}
	}
}
