package com.tonmoy.bubt.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private int clientId = 0;
    private final List<Client> clientList = new ArrayList<>();
    private boolean stop = true;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket server  = new ServerSocket(port);
        stop = false;
        while (!stop){
           Socket socket =  server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Client client = new Client(clientId,this,socket,dos,dis);
           Thread clientThread = new Thread(client);
           clientThread.start();
           clientList.add(client);
           clientId++;
        }
    }

    public int getPort() {
        return port;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isStop() {
        return stop;
    }
}
