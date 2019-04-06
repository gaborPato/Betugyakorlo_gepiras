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
public class NO_OKTimeValue extends Exception{

    @Override
    public String toString() {
        return "Use correct value:300-3000 ms";
    }
    
}
