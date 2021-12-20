package pers.yzcam.udp.client.start;

import pers.yzcam.udp.client.ClientSystem;

/**
 * @author cat
 */
public class ClientStart {
    public static void main(String[] args) {
        ClientSystem client = new ClientSystem();
        client.clientSendAndReceive();
    }
}
