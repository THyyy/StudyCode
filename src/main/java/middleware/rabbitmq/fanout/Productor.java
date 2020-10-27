package middleware.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import lombok.extern.slf4j.Slf4j;
import middleware.rabbitmq.RabbitMqUtils;

import java.io.IOException;

/**
 * 消息队列生产者 -- 广播模式下
 *
 * @author yuancome
 * @date 2020/10/26
 */
@Slf4j
public class Productor {
    public static void main(String[] args) {
        // 获取连接对象
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            log.error("获取rabbitmq通道异常：", e);
        }
        // 将通道声明指定交换机 // 参数1：交换机名称，参数2：交换机类型 fanout 广播类型
        try {
            channel.exchangeDeclare("log", "fanout");
        } catch (IOException e) {
            log.error("声明rabbitmq交换机异常：", e);
        }
        // 发送消息
        try {
            channel.basicPublish("log", "", null, "fanout type message".getBytes());
        } catch (IOException e) {
            log.error("发送消息到rabbitmq异常：", e);
        }
        RabbitMqUtils.closeConnectionAndChannel(connection, channel);

    }
}
