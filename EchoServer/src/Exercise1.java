/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RolfMoikjær
 */
public class Exercise1 implements Runnable {

    Socket s;
    BufferedReader in;
    PrintWriter out;
    String echo;
    ServerProtocol protocol = new ServerProtocol();

    public Exercise1(Socket socket) {
        s = socket;

    }

    public static String getTimeDate() {
        SimpleDateFormat sDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date now = new Date();
        String strDate = sDate.format(now);
        return strDate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                echo = protocol.processInput(in.readLine());
                System.out.println(echo);
                out = new PrintWriter(s.getOutputStream(), true);
                out.println(echo);
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 4321;
        if (args.length == 2) {
            System.out.println("args found");
            ip = args[0];
            port = Integer.parseInt(args[1]);
        }
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));

        while (true) {
            Exercise1 e = new Exercise1(ss.accept());
            Thread t1 = new Thread(e);
            t1.start();
        }

    }
}
