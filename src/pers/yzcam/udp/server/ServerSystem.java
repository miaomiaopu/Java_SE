package pers.yzcam.udp.server;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cat
 */
public class ServerSystem {
    /**
     * 服务器地址
     */
    public static final String LOCAL_HOST = "localhost";
    /**
     * 服务器端口
     */
    public static final int LOCAL_PORT = 7979;
    /**
     * 服务器套接字
     */
    private DatagramSocket socket;

    /**
     * 服务器端信息交互
     */
    public void sendAndReceive() {
        initDatagramSocket();
        while (true) {
            System.out.println("等待接收数据");
            Scanner scanner = new Scanner(System.in);
            DatagramPacket receivePacket = initDatagramPacket();
            try {
                socket.receive(receivePacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("接收的数据长度: " + receivePacket.getLength());
            System.out.println("接收的数据: " + new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength()));
            System.out.println("输入回复的数据:");
            String returnMessage = scanner.next();
            byte[] returnBuf = returnMessage.getBytes();
            DatagramPacket returnPacket = new DatagramPacket(returnBuf, returnBuf.length);
            try {
                returnPacket.setAddress(InetAddress.getLocalHost());
                returnPacket.setPort(9090);
                socket.send(returnPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 构建数据报包
     *
     * @return DatagramPacket
     */
    private DatagramPacket initDatagramPacket() {
        DatagramPacket packet = null;
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        return packet;
    }

    /**
     * 构建服务器套接字
     */
    private void initDatagramSocket() {
        if (socket == null) {
            try {
                socket = new DatagramSocket(LOCAL_PORT);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    public ServerSystem() {
    }
}
