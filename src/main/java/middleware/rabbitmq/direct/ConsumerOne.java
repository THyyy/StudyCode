package middleware.rabbitmq.direct;

import com.rabbitmq.client.*;
import middleware.rabbitmq.RabbitMqUtils;

import java.io.IOException;

/**
 * rabbitmq消费者 -- direct 模式下
 *
 * @author yuancome
 * @date 2020/10/26
 */

public class ConsumerOne {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();

        // 通道绑定交换机
        String exchangeName = "log_direct";
        channel.exchangeDeclare(exchangeName, "direct");

        // 临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 通道基于 routingKey 绑定队列
        channel.queueBind(queueName, exchangeName, "error");
        // 消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1，消费消息：" + new String(body));
            }
        });
    }
}
