package com.tonmoy.bubt.server;


import com.tonmoy.bubt.serverx.ServerX;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class Client implements Runnable {

    private final Server server;
    private final Socket socket;
    private final int id;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Client(int id,Server server, Socket socket, DataOutputStream dataOutputStream, DataInputStream dataInputStream) {
        this.server = server;
        this.id = id;
        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;

    }

    @Override
    public void run() {

        System.out.println("Client "+id +" is join");
        String received;

        while (true)  {
            try {
                // receive the string
                received = dataInputStream.readUTF();
                System.out.println(received);
                if(received.equals("logout")){
                    this.socket.close();
                    break;
                }

            }
            catch (IOException e) {

                e.printStackTrace();
            }

        }
        try {
            // closing resources
            this.dataInputStream.close();
            this.dataOutputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
