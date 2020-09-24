package socket.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty 客户端
 *
 * @author yuancome
 * @date 2020/9/10
 */

public class NettyClient {
    public void connect(String host, int port) throws Exception {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            /**
             *EventLoop的组
             */
            bootstrap.group(worker);
            /**
             * 用于构造socketchannel工厂
             */
            bootstrap.channel(NioSocketChannel.class);
            /**设置选项
             * 参数：Socket的标准参数（key，value），可自行百度
             保持呼吸，不要断气！
             * */
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            /**
             * 自定义客户端Handle（客户端在这里搞事情）
             */
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new SimpleClientHandler());
                }
            });
            /** 开启客户端监听*/
            ChannelFuture f = bootstrap.connect(host, port).sync();
            /**等待数据直到客户端关闭*/
            f.channel().closeFuture().sync();
        } finally {
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        NettyClient client=new NettyClient();
        client.connect("127.0.0.1", 9999);

    }

}
