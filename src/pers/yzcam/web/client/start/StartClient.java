package pers.yzcam.web.client.start;

import pers.yzcam.web.client.ClientSystem;

/**
 * @author cat
 */
public class StartClient {
    /**
     * 实现客户端套接字与服务器交互的过程
     * 1 创建想要绑定的本机地址与端口号以及远程服务器套接字地址与端口号
     * 2 创建套接字对象并绑定本机地址及端口号
     * 3 尝试连接目标远程服务器
     * 4 创建基于套接字的输入输出流
     * 5 实现信息交互
     */
    public static void main(String[] args) {
        ClientSystem client = new ClientSystem();
        System.out.println("客户端ip地址: " + client.getLocalAddress());
        client.sendAndReceive();
    }
}
