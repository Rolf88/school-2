/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author RolfMoikjær
 */
public class BackupTask implements Runnable {

    List<String> lines = new ArrayList();

    FileWriter writer = null;

    public BackupTask(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BackupTask.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // Open a text file for writing (without append, that is, existing content will be overwritten)
                writer = new FileWriter("backup.txt", false);
                PrintWriter out = new PrintWriter(writer);
                for (String line : lines) {
                    out.println(line);

                }
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(BackupTask.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(BackupTask.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
