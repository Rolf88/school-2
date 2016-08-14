/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.client;

import echoclient.EchoClient;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RolfMoikjær
 */
public class ClientConnection extends Observable implements Runnable {

    private final String adress;
    private final int port;
    private EchoClient client;

    public ClientConnection(String adress, int port) {
        this.adress = adress;
        this.port = port;
    }

    @Override
    public void run() {

        try {
            client = new EchoClient();
            client.connect(adress, port);

            Thread receiverThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        while (true) {
                            String response = client.receive();

                            setChanged();
                            notifyObservers(response);
                        }
                    } catch (Exception e) {
                    }
                }
            });
            receiverThread.start();

            client.send("Hello World");

            receiverThread.join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void close() {
        if (this.client != null) {
            try {
                this.client.stop();
            } catch (IOException ex) {
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
