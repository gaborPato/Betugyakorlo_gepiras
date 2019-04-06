/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyListenerTest;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author gabor
 */
public class KeyListenerTest {
     public static void main(String[] args) {
        JFrame ablak = new JFrame("Snake game");
        ablak.setVisible(true);
        ablak.setSize(new Dimension(600,600));
        //ablak.setFocusable(true);
        ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ablak.addKeyListener(new KeyAdapter() {
             @Override
                public void keyPressed(KeyEvent e) {
                   System.out.println("keyPressed");
                }

//                @Override
//                public void keyTyped(KeyEvent e) {
//                    System.out.println("keyTyped");
//                }

//                @Override
//                public void keyReleased(KeyEvent e) {
//                    System.out.println("keyReleased");
//                }
        });
         
        ablak.setVisible(true);
    }
}

