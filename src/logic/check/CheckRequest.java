/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.check;

import exceptions.IllegalCharacter;
import exceptions.InsufficientQuantityCharacters;
import exceptions.NO_OKTimeValue;
import exceptions.NoTimeException;
import exceptions.NotExcersizeException;
import exceptions.SameCharsException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gabor
 */
public class CheckRequest {      

    private CheckRequest() {
    }
    
    public static void checkCharacters(String excersise) throws InsufficientQuantityCharacters, IllegalCharacter, NotExcersizeException, SameCharsException{
     
        
        if(excersise.startsWith("Enter You Want"))
            throw new NotExcersizeException();
        //same characters check:
        
        char[] toCharArray = excersise.toCharArray();
        
        Set<Character> charset=new LinkedHashSet<>();
       
        for (char c : toCharArray) {
            if(!charset.add(c))
                throw new SameCharsException();
        }
       
       
       //length check:
        if(excersise.length()<3 || excersise.length()>35){
                throw new InsufficientQuantityCharacters();
                
        }
        
        
       //illegal characters check:


        String regex="^[a-z0-9,.-_áéűúőóüöí]*$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(excersise);
        if (!matcher.matches()) {
            throw  new IllegalCharacter();
        }
        
    }
   public static int checkTimeRequest(String timeSTR) throws NoTimeException, NO_OKTimeValue,NumberFormatException{
     
       
       int waitTime=1000;//Default value
       if(timeSTR.isEmpty())
           throw new NoTimeException();
    
       try {
            waitTime = Integer.parseInt(timeSTR);
            if(waitTime<300 || waitTime>3000 )
                throw new NO_OKTimeValue();
           
       } catch (NumberFormatException e) {
           throw e;
       }
  return waitTime;
   } 
}
