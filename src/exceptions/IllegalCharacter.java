/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author gabor
 */
public class IllegalCharacter extends Exception {

    @Override
    public String toString() {
        return "do not use illegal characters";
    }
    
}
