package com.huang.mq.ex1;

import com.huang.mq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/23 21:47
 * @Description:
 */
public class Recv
{
    private static final String QUEUE = "queue1";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        //1.获取连接
        Connection connection = ConnectionUtil.getFactory().newConnection();

        //2.创建频道
        final Channel channel = connection.createChannel();

        boolean durable = false;
        //3.队列声明
        channel.queueDeclare(QUEUE,durable, false, false, null);

        System.out.println("Recv Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                try
                {
                    Thread.sleep(10000);
                    //int i = 10/0;

                    String message = new String(body, "UTF-8");
                    System.out.println("Recv Received '" + message + "'");

                    //手动ack
                    channel.basicAck(envelope.getDeliveryTag(),false);

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    //抛弃此条消息
                    //channel.basicNack(envelope.getDeliveryTag(), false, false);
                    //重新放入队列
                    channel.basicNack(envelope.getDeliveryTag(), false, true);
                }

            }
        };


        //添加监听器，第二个参数为true,表示自动应答。表示一旦mq将消息分发给消费者，就会把消息从mq内存中删除。。
        //如果是这种情况，当杀死正在执行的消费者，就会丢失正在处理的消息。
        boolean autoAck = false;
        channel.basicConsume(QUEUE,autoAck,consumer);

        //别忘了关掉。
        //发现一个问题，就是这边如果关掉了，那么接受不到了。注意。。
        //channel.close();
        //connection.close();


    }
}
