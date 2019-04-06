/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author gaborpato
 */
public class CharactersViewThread extends Thread {

    CharExercise che;
    int waitTime;

    public CharactersViewThread(CharExercise che, int waitTime) {
        super();
        this.che = che;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        for (String exercChar : che.exercChars) {
            try {
                Thread.sleep(waitTime);
                che.exerJLabel.setForeground(Color.black);
                System.out.println(exercChar);
                che.exerJLabel.setText(exercChar);
                che.container.invalidate();
                che.container.repaint();
            }catch (InterruptedException ex) {
                Logger.getLogger(CharactersViewThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread.sleep(waitTime);
            che.GoButton.setEnabled(true);
            che.EnterCharTextField.setEditable(true);
            che.canExercise = false;
            che.exerJLabel.setText("");
            JOptionPane.showMessageDialog(null,
                    "hibas vagy elszalasztott leutes: " + (che.exercChars.length - che.goodAnswer));
            che.goodAnswer = 0;

        } catch (InterruptedException ex) {
            Logger.getLogger(CharactersViewThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
