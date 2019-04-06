/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import java.util.Arrays;

/**
 *
 * @author gaborpato
 */
public class CharTest {
    
    public static void main(String[] args) {
        
        
        String str="asdfghjjkl";
        
        char[] toCharArray = str.toCharArray();
        System.out.println(toCharArray.length);
        String toString="";
        for (char c : toCharArray) {
            System.out.println(c); 
            toString+=Character.toString(c);
        }
        
        
        System.out.println(toString.length());
        
        System.out.println(toString);
        
        char c='j';
        char c1=64;
        System.out.println(Character.getNumericValue(c)); 
      
    }
    
}
