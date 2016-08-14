/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author RolfMoikjær
 */
public class Exercise1a {

    public static void main(String[] args) {
        new Thread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png", 0).start();
    }

    public static class Thread1 extends Thread {
        int res1;
        String link;

        public Thread1(String link, int res1) {
            this.link = link;
            this.res1 = res1;
        }

        protected byte[] getBytesFromUrl(String url) {
            ByteArrayOutputStream bis = new ByteArrayOutputStream();
            try {
                InputStream is = new URL(url).openStream();
                byte[] bytebuff = new byte[4096];
                int read;
                while ((read = is.read(bytebuff)) > 0) {
                    bis.write(bytebuff, 0, read);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return bis.toByteArray();
        }

        public synchronized void printArray(String url) {
            res1 = 0;

            for (byte res : getBytesFromUrl(url)) {
                res1 += res;
            }
            System.out.println(res1);
        }

        public int getRes1() {
            return res1;
        }

        public void setRes1(int res1) {
            this.res1 = res1;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void run() {
            printArray(link);
        }

    }
}
