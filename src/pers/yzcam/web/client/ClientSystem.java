package pers.yzcam.web.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * 客户端套接字系统
 *
 * @author cat
 */
public class ClientSystem {
    /**
     * 本地主机地址
     */
    private InetSocketAddress localAddress;
    /**
     * 本地主机端口号
     */
    public static final int LOCAL_PORT = 7575;

    /**
     * 远程服务器地址
     */
    private InetSocketAddress remoteAddress;
    /**
     * 远程服务器端口号
     */
    public static final int REMOTE_PORT = 7070;

    /**
     * 客户端套接字
     */
    private Socket clientSocket;
    /**
     * 输入流
     */
    private InputStream inputStream;
    /**
     * 输出流
     */
    private OutputStream outputStream;
    /**
     * 文件输入流
     */
    private DataInputStream dataInputStream;
    /**
     * 文件输出流
     */
    private DataOutputStream dataOutputStream;

    public InetSocketAddress getLocalAddress() {
        return localAddress;
    }

    /**
     * 构建本机主机地址
     */
    private void initLocalAddress() {
        if (localAddress == null) {
            localAddress = new InetSocketAddress("10.15.130.99", LOCAL_PORT);
        }
    }

    /**
     * 构建客户端套接字实例
     */
    private void initClientSocket() {
        if (clientSocket == null) {
            clientSocket = new Socket();
        }
    }

    /**
     * 将套接字绑定到主机地址
     */
    private void bindAddress() {
        try {
            clientSocket.bind(localAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建服务器地址
     */
    private void initRemoteAddress() {
        if (remoteAddress == null) {
            remoteAddress = new InetSocketAddress("10.15.130.99", REMOTE_PORT);
        }
    }

    /**
     * 请求连接到远程服务器
     */
    private void connectRemoteServer() {
        try {
            clientSocket.connect(remoteAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于套接字创建输入输出流
     */
    public void createSocketInputStreamAndOutputStream() {
        try {
            if (clientSocket.isConnected()) {
                inputStream = clientSocket.getInputStream();
                outputStream = clientSocket.getOutputStream();
                dataInputStream = new DataInputStream(inputStream);
                dataOutputStream = new DataOutputStream(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现与服务器进行信息交互
     */
    public void sendAndReceive() {
        connectRemoteServer();
        createSocketInputStreamAndOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入信息，回车发送");
            String message = scanner.next();
            try {
                dataOutputStream.writeUTF(message);
                String backMessage = dataInputStream.readUTF();
                System.out.println("服务器返回消息: " + backMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ClientSystem() {
        initLocalAddress();
        initClientSocket();
        bindAddress();
        initRemoteAddress();
    }
}
