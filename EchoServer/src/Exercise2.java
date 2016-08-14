
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RolfMoikjær
 */
public class Exercise2 implements Runnable {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String echo;
    String line;

    public Exercise2(Socket soc) {
        socket = soc;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),
                    true);

            while (true) {
                System.out.println("Write a line");
                line = scanner.nextLine();
                out.println(line);
                echo = in.readLine();
                System.out.println("Got " + echo + " back from server");

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4321);
        Exercise2 sw = new Exercise2(s);
        Thread t1 = new Thread(sw);
        t1.start();
    }
}
