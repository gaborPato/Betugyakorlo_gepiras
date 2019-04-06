package testP;

import java.util.Scanner;

/**
 *
 * @author gabor
 */
public class CheckSameCharsTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] toCharArray = input.toCharArray();
        double inpLength = input.length();

        int numericValue = 0;
        for (char c : toCharArray) {

            numericValue += Character.getNumericValue(c);
        }
       
        String res=(numericValue/inpLength==Character.getNumericValue(toCharArray[0])) ? "Same chars" : "Diff chars";
        System.out.println(res);
    }
}
