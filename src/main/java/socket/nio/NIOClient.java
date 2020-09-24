package socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * NIO 客户端测试
 *
 * @author yuancome
 * @date 2020/9/8
 */
@Slf4j
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 先向服务端发送消息
        log.info("发送消息前");
        outputStream.write("hello server\0".getBytes());
        log.info("发送消息后");
        // 读取服务端响应的消息
        int b;
        while ((b = inputStream.read()) != 0) {
            System.out.println((char) b);
        }
        System.out.println();

        socket.close();
    }
}
