package pers.yzcam.udp.server.start;

import pers.yzcam.udp.server.ServerSystem;

/**
 * @author cat
 */
public class ServerStart {
    public static void main(String[] args) {
        ServerSystem server = new ServerSystem();
        server.sendAndReceive();
    }
}
