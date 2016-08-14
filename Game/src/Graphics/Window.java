/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import newGame.JavaGame;

/**
 *
 * @author RolfMoikjær
 */
public class Window extends JFrame {

    public Window(Graphics g) {
        JFrame frame = new JFrame();
        
        frame.setTitle("JavaGame");
        frame.setSize(550, 550);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        g.setColor(Color.red);
        g.fillRect(0, 0, 550, 550);
        repaint();
    }
}
