package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * RPC框架Demo
 *
 * @author yuancome
 * @date 2020/9/24
 */

public class RpcFrameworkProxy {

    @SuppressWarnings("unchecked")
    public static <T> T create(final Object target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                // 建立 Socket 对象，绑定 IP 和 端口
                Socket socket = new Socket("localhost", 8080);
                // 建立 socket 输出字节流
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                // 获取目标类类名
                output.writeUTF(target.getClass().getName());
                // 获取目标类方法名
                output.writeUTF(method.getName());
                // 获取目标方法参数类型
                output.writeObject(method.getParameterTypes());//参数类型
                // 获取目标方法参数值
                output.writeObject(args);//参数值
                // 获取 socket 输入字节流
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                // 获取响应结果
                Object result = input.readObject();
                // 如果结果对象是异常类，那么就抛出该异常
                if (result instanceof Throwable) {
                    throw (Throwable) result;
                }
                // 关闭字节流 和 socket 流
                input.close();
                output.close();
                socket.close();
                return result;
            }

        });
    }
}
