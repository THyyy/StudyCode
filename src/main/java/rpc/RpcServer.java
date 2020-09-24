package rpc;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RPC服务端
 *
 * @author yuancome
 * @date 2020/9/24
 */
@Slf4j
public class RpcServer {

    public static ConcurrentHashMap<String, Object> classMap = new ConcurrentHashMap<String, Object>();

    public void invoker(int port) throws Exception {
        ServerSocket server = new ServerSocket(port);
        for (; ; ) {
            try {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    ObjectOutputStream out = null;
                    ObjectInputStream in = null;
                    @Override
                    public void run() {
                        try {
                            try {
                                log.info("开始远程调用————————");
                                out = new ObjectOutputStream(socket.getOutputStream());
                                in = new ObjectInputStream(socket.getInputStream());
                                String className = in.readUTF();
                                String methodName = in.readUTF();
                                Class<?>[] parameterType = (Class<?>[]) in.readObject();
                                Object[] arguments = (Object[]) in.readObject();
                                Object claszz = null;
                                if (!classMap.containsKey(className)) {
                                    try {
                                        claszz = Class.forName(className).newInstance();
                                        classMap.put(className, claszz);
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    claszz = classMap.get(className);
                                }

                                Method method = claszz.getClass().getMethod(methodName, parameterType);
                                Object result = method.invoke(claszz, arguments);
                                out.writeObject(result);
                                log.info("结束远程调用————————");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (SecurityException e) {
                                e.printStackTrace();
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } finally {
                                out.close();
                                in.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        RpcServer server=new RpcServer();
        try {
            server.invoker(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
