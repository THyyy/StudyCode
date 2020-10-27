package middleware.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import middleware.rabbitmq.RabbitMqUtils;

import java.io.IOException;

/**
 * 消息队列生产者 -- direct 模式下
 *
 * @author yuancome
 * @date 2020/10/27
 */

public class Producer {
    public static void main(String[] args) throws IOException {
        // 获取连接
        Connection connection = RabbitMqUtils.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 通道声明交换机
        String exchangeName = "log_direct";
        channel.exchangeDeclare(exchangeName, "direct");
        // 发送消息
        String routingKey = "error";
        channel.basicPublish(exchangeName, routingKey, null, ("这是一个基于direct模型的消息，基于routingKey：" + routingKey + " 发送消息").getBytes());


        // 关闭消息
        RabbitMqUtils.closeConnectionAndChannel(connection, channel);
    }
}
