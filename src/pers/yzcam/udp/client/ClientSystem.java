package pers.yzcam.udp.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 实现使用UDP协议收发数据报包
 *
 * @author cat
 */
public class ClientSystem {
    /**
     * 本地主机地址
     */
    private SocketAddress localAddress;
    /**
     * 远程服务器地址
     */
    private SocketAddress remoteAddress;
    /**
     * 主机地址
     */
    private InetAddress hostName;
    /**
     * 本地端口
     */
    private static final int LOCAL_PORT = 9090;
    /**
     * 远程服务器端口
     */
    public static final int REMOTE_PORT = 7979;

    /**
     * 构建数据报包;
     *
     * @param bytes 构建数据报包的数据
     * @return DatagramPacket
     */
    private DatagramPacket initDatagramPacket(byte[] bytes) {
        DatagramPacket packet = null;
        packet = new DatagramPacket(bytes, bytes.length);
        packet.setSocketAddress(remoteAddress);
        return packet;
    }

    /**
     * 构建一个绑定本机指定端口的UDP套接字实例
     *
     * @return DatagramSocket
     */
    private DatagramSocket initDatagramSocket() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(LOCAL_PORT);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return socket;
    }

    /**
     * 构建绑定到套接字的本地主机地址
     */
    private void initLocalAddress() {
        if (localAddress == null) {
            try {
                hostName = Inet4Address.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            localAddress = new InetSocketAddress(hostName, LOCAL_PORT);
        }
    }

    /**
     * 构建绑定到套接字的远程服务器地址
     */
    private void initRemoteAddress() {
        if (remoteAddress == null) {
            try {
                hostName = Inet4Address.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            remoteAddress = new InetSocketAddress(hostName, REMOTE_PORT);
        }
    }

    /**
     * 连接到远程服务器
     */
    private void connectRemoteServer(DatagramSocket socket) {
        try {
            socket.connect(remoteAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端的信息交互
     */
    public void clientSendAndReceive() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        /*
        用户构建数据
         */
            System.out.println("输入数据:");
            String message = scanner.next();
            byte[] bytes = message.getBytes();
            DatagramPacket tempPacket = initDatagramPacket(bytes);
        /*
        获取udp套接字对象并连接远程主机
         */
            DatagramSocket tempSocket = initDatagramSocket();
            connectRemoteServer(tempSocket);
        /*
        发送数据和接收数据并处理
         */
            try {
                tempSocket.send(tempPacket);
                byte[] returnBytes = new byte[1024];
                DatagramPacket returnPacket = new DatagramPacket(returnBytes, returnBytes.length);
                tempSocket.receive(returnPacket);
                System.out.println("返回的数据长度: " + returnPacket.getLength());
                System.out.println("返回的数据: " + new String(returnPacket.getData(), returnPacket.getOffset()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 启动客户端
     */
    public ClientSystem() {
        initLocalAddress();
        initRemoteAddress();
    }
}
