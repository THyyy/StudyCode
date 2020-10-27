package middleware.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMq工具类
 *
 * @author yuancome
 * @date 2020/10/26
 */
@Slf4j
public class RabbitMqUtils {

    public static Connection getConnection() {
        // 创建连接 MQ 的工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接 rabbitmq 的主机
        connectionFactory.setHost("127.0.0.1");
        // 设置端口号
        connectionFactory.setPort(5672);
        // 设置用户名、密码
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("123456");
        // 获取连接对象
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            log.error("获取rabbitmq连接异常：", e);
        } catch (TimeoutException e) {
            log.error("获取rabbitmq连接超时：", e);
        }
        return connection;
    }

    public static void closeConnectionAndChannel(Connection connection, Channel channel) {
        // 关闭通道
        try {
            channel.close();
        } catch (IOException e) {
            log.error("关闭rabbitmq通道异常：", e);
        } catch (TimeoutException e) {
            log.error("关闭rabbitmq超时异常：", e);
        }
        // 关闭连接
        try {
            connection.close();
        } catch (IOException e) {
            log.error("关闭rabbitmq连接异常：", e);
        }
    }
}
