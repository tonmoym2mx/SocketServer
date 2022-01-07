package com.tonmoy.bubt;

import com.tonmoy.bubt.server.Server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Server server = new Server(5555);
        try {
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
