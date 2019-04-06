/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.staticElement;

import javax.swing.JLabel;

/**
 *
 * @author gabor
 */
public class WaitJLabel extends JLabel {
    private  final String TEXT="Wait before next character (ms) : ";
   
    public WaitJLabel() {
        super();
    setText(TEXT);
    setBounds(340, 60, 200, 20);}

 
}
