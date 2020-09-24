// package basice.multithread;
//
// import java.io.IOException;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
//
// /**
//  * BIO 阻塞IO测试
//  *
//  * @author yuancome
//  * @date 2020/9/8
//  */
//
// public class BIOTest {
//
//     // 伪代码
//     public static void main(String[] args) {
//         ExecutorService executorService = Executors.newFixedThreadPool(100);
//         ServerSocket serverSocket = new ServerSocket();
//         serverSocket.bind(8088);
//         while (!Thread.currentThread().interrupted()) {
//             Socket socket = null;
//             try {
//                 socket = serverSocket.accept();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             executorService.submit(new ConnectIOnHandler(socket));
//         }
//     }
//
//     class ConnectIOnHandler extends Thread {
//         private Socket socket;
//
//         public ConnectIOnHandler(Socket socket) {
//             this.socket = socket;
//         }
//
//         @Override
//         public void run() {
//             while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
//                 String someThing = null;//读取数据
//                 try {
//                     someThing = socket.getInputStream().toString();
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//                 if (someThing != null) {
//                     //处理数据
//                     try {
//                         socket.getOutputStream();//写数据
//                     } catch (IOException e) {
//                         e.printStackTrace();
//                     }
//                 }
//
//             }
//         }
//     }
// }
