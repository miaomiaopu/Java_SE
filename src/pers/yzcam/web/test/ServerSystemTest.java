package pers.yzcam.web.test;

import pers.yzcam.web.server.ServerSystem;

/**
 * @author cat
 */
public class ServerSystemTest {
    public static void main(String[] args) {
        ServerSystem serverSystem = new ServerSystem();
        System.out.println(serverSystem.getLocalhostIP().getHostAddress());
        System.out.println(serverSystem.getLocalhostIP().getHostName());
        System.out.println();

        System.out.println(serverSystem.getLocalhostIP());
        serverSystem.startAccept();
    }
}
