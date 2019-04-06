
package testP;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author gabor
 */
public class utf8Test {
    public static void main(String[] args) {
        Font f=new Font("Cuorier New",0, 12);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(3);
        JTextField te=new JTextField();
        te.setFont(f);
        te.setText("delete");
        te.setSize(300, 20);
        frame.add(te);
        JButton button=new JButton("go");
        frame.add(button);
        button.addActionListener(l->{
        
        String inp=te.getText();
            char[] toCharArray = inp.toCharArray();
            System.out.println(toCharArray);
            for (char c : toCharArray) {
                System.out.println(Character.getNumericValue(c));
            }
        });
       
        frame.setVisible(true);
        
                }
}
