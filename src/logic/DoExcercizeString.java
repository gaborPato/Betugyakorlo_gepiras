/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Random;
import logic.interFaces.MakeExcersString;

/**
 *
 * @author gabor
 */
public class DoExcercizeString {

    private static MakeExcersString doExcerString;

    public static MakeExcersString getDoExcerString() {
        return doExcerString;
    }

    private DoExcercizeString() {
    }

    static {
        doExcerString = ((String excSBef) -> {
            char[] toCharArray = excSBef.toCharArray();
            String[] result = new String[50];
            for (int i = 0; i < result.length; i++) {
                if (i > 0) {
                    do{result[i] = "" + toCharArray[new Random().nextInt(toCharArray.length)];}
                    while (result[i].equals(result[i - 1])) ;
                        

                } else {
                    result[i] = "" + toCharArray[new Random().nextInt(toCharArray.length)];
                }

            }
            return result;
        });
    }

    public static String[] makeCharArray(MakeExcersString me, String ExcString) {
        return me.MakeExcersizeString(ExcString);
    }
}
