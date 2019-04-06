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
        double exercLenght=excersise.length();
        int value=0;
        for (char c : toCharArray) {
            value+=Character.getNumericValue(c);
        }
       if(value/exercLenght==Character.getNumericValue(toCharArray[0]))
           throw new SameCharsException();
       
       //length check:
        if(excersise.length()<3 || excersise.length()>35){
                throw new InsufficientQuantityCharacters();
                
        }
        
        
       //illegal characters check:
        char[] exerciseCharArray = excersise.toCharArray();
        System.out.println(exerciseCharArray);
        char [] illegalChar=new char[]{'~','ˇ','^','˘','°','˛','`','˙','´','˝','¨','¸','÷','×',
        'ł','Ł','ß','¤',' '};
        for (int i = 0; i < illegalChar.length; i++) {
            for (int j = 0; j < exerciseCharArray.length; j++) {
                if(illegalChar[i]==exerciseCharArray[j])
                    throw new IllegalCharacter();
                
            }
            
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
