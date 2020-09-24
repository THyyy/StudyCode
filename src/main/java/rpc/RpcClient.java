package rpc;

/**
 * RPC客户端
 *
 * @author yuancome
 * @date 2020/9/24
 */

public class RpcClient {
    public static void main(String[] args) {
        // 设置调用接口
        RpcService userService = new RpcServiceImpl();
        // 设置调用代理类
        RpcFrameworkProxy proxy=new RpcFrameworkProxy();
        // 通过代理类进行服务调用，并获取返回结果
        RpcService userProxy=proxy.create(userService);
        // 打印返回结果
        System.out.println(userProxy.getName("dfdhfah"));
    }
}
