/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keystrokeTest;

import java.util.Scanner;
import javafx.scene.input.KeyCode;
import javax.swing.KeyStroke;

/**
 *
 * @author gaby
 */
public class KeyStrokejTest {
    public static void main(String[] args) {
        
        KeyStroke ks;
        Scanner sc=new Scanner(System.in);
        
        String inp=sc.nextLine();
        
       char[] charArray=new char[inp.length()];
        
        for (int i = 0; i < inp.length(); i++) {
           charArray[i]=inp.charAt(i);
            System.out.print(charArray[i]);

        
        
                
         ks=KeyStroke.getKeyStroke(charArray[i], 0);
            int keyCode = ks.getKeyCode();
            System.out.print(", keyCode:"+keyCode);
        }
        
        
        
        
        
    }
    
}
