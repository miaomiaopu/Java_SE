package pers.yzcam.web.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Java 套接字网络通讯应用，服务器端
 *
 * @author cat
 */
public class ServerSystem {
    /**
     * 端口号
     */
    public static final int PORT = 7070;
    /**
     * 允许最大队列长度
     */
    private static final int MAX_BACK_LOG = 20;
    /**
     * 本地想要绑定到 ServerSocket 套接字的辅助组件
     */
    private InetAddress localhostIP;
    /**
     * 实现套接字网络信息交互服务器端套接字对象
     */
    private ServerSocket serverSocket;
    /**
     * 服务器端Socket套接字
     */
    private Socket clientSocket;
    /**
     * 客户端输入流，用来读取用户发送的数据
     */
    private InputStream input;
    /**
     * 使用缓冲流处理用户信息读取
     */
    private DataInputStream dataInput;
    /**
     * 客户端输出流，用来发送给用户信息
     */
    private OutputStream output;
    /**
     * 使用缓冲流处理需要发送的信息
     */
    private DataOutputStream dataOutput;

    public InetAddress getLocalhostIP() {
        return localhostIP;
    }

    /**
     * 构建主机IP地址
     */
    public void initInetAddress() {
        if (localhostIP != null) {
            return;
        }
        try {
            localhostIP = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建 ServerSocket 对象
     */
    private void initServerSocket() {
        if (serverSocket != null) {
            return;
        }
        try {
            serverSocket = new ServerSocket(PORT, MAX_BACK_LOG, localhostIP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现信息交互方法
     */
    private void sendAndReverse() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                if (clientSocket.isConnected() && !clientSocket.isClosed()) {
                    // 读取用户信息
                    String message = dataInput.readUTF();
                    System.out.println("用户信息: " + message);
                    // 服务器回复的信息
                    String reverseMessage = scanner.next();
                    dataOutput.writeUTF(reverseMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 启动服务器套接字等待客户端请求
     */
    public void startAccept() {
        try {
            if (!serverSocket.isBound()) {
                serverSocket.bind(new InetSocketAddress(PORT), MAX_BACK_LOG);
            }
            System.out.println("等待连接");
            clientSocket = serverSocket.accept();
            System.out.println("已连接");
                /*
                  基于客户端套接字建立输入输出流
                 */
            input = clientSocket.getInputStream();
            dataInput = new DataInputStream(input);
            output = clientSocket.getOutputStream();
            dataOutput = new DataOutputStream(output);
            sendAndReverse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化方法
     */
    public void init() {
        initInetAddress();
        initServerSocket();
    }

    public ServerSystem() {
        init();
    }

}
