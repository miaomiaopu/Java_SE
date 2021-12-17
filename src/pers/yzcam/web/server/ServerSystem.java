package pers.yzcam.web.server;

import java.io.IOException;
import java.net.*;

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
     * 启动服务器套接字等待客户端请求
     */
    public void startAccept() {
        try {
            if (!serverSocket.isBound()) {
                serverSocket.bind(new InetSocketAddress(PORT), MAX_BACK_LOG);
            }
            for (int i = 0; i < MAX_BACK_LOG; i++) {
                System.out.println("等待连接");
                Socket clientSocket = serverSocket.accept();
                System.out.println("已连接");
            }
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
