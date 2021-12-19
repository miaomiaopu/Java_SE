package pers.yzcam.web.server.start;

import pers.yzcam.web.server.ServerSystem;

/**
 * @author cat
 */
public class StartServer {
    public static void main(String[] args) {
        ServerSystem server = new ServerSystem();
        System.out.println("服务器ip地址: " + server.getLocalhostIP());
        server.startAccept();
    }
}
