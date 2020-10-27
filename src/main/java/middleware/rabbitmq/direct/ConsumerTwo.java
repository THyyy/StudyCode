package middleware.rabbitmq.direct;

import com.rabbitmq.client.*;
import middleware.rabbitmq.RabbitMqUtils;

import java.io.IOException;

/**
 * 消息队列消费者 -- direct 模式下
 *
 * @author yuancome
 * @date 2020/10/27
 */

public class ConsumerTwo {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "log_direct";
        channel.exchangeDeclare(exchangeName,"direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, exchangeName,"info");
        channel.queueBind(queueName, exchangeName,"warn");
        channel.queueBind(queueName, exchangeName,"error");
        channel.basicConsume(queueName,true,new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2：" + new String(body));
            }
        });
    }
}
