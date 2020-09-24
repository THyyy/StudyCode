package socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO 服务端测试案例
 *
 * @author yuancome
 * @date 2020/9/8
 */
@Slf4j
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 初始化选择器
        Selector selector = Selector.open();
        // 初始化 TCP 连接监听通道
        ServerSocketChannel listenChannel = ServerSocketChannel.open();
        listenChannel.bind(new InetSocketAddress("localhost",9999));
        listenChannel.configureBlocking(false);
        // 注册一个选择器
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 初始化一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        while (true) {
            log.info("开始监听....");
            // 阻塞，直到有监听的事件发生
            selector.select();
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            // 通过迭代器依次访问select出来的Channel事件
            while (keyIterator.hasNext()) {
                log.info("开始遍历事件....");
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    log.info("事件是可接收的");
                    SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    log.info("与【{}】建立了连接", channel.getRemoteAddress());
                } else if (key.isReadable()) {
                    log.info("事件是可读取的");
                    byteBuffer.clear();
                    // 当读取流到末尾的时候必须关闭TCP连接或者取消监听 READ 事件，否则会无限循环
                    if (((SocketChannel) key.channel()).read(byteBuffer) == -1) {
                        key.channel().close();
                        continue;
                    }

                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        byte b = byteBuffer.get();
                        // 如果客户端消息末尾的 0
                        if (b == 0) {
                            System.out.println();
                            // 响应客户端
                            byteBuffer.clear();
                            byteBuffer.put("hello client!\0".getBytes());
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()) {
                                ((SocketChannel) key.channel()).write(byteBuffer);
                            }
                        } else {
                            System.out.println((char) b);
                        }
                    }
                }
                // 移除已经处理的事件
                keyIterator.remove();
            }
        }
    }
}
