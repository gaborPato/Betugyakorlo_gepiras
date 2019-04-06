package view;

import exceptions.IllegalCharacter;
import exceptions.InsufficientQuantityCharacters;
import exceptions.NO_OKTimeValue;
import exceptions.NoTimeException;
import exceptions.NotExcersizeException;
import exceptions.SameCharsException;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logic.DoExcercizeString;
import logic.check.CheckRequest;
import view.staticElement.WaitJLabel;

/**
 *
 * @author gabor
 */
public class CharExercise extends JFrame {

    Container container;

    javax.swing.JTextField EnterCharTextField;

    javax.swing.JButton GoButton;
    private TimeTextField timeTf;

    boolean canExercise = false;
    boolean focus;
    int goodAnswer;
    private final Color   MYGREEN=new Color(0, 140, 0);
    private final Color   MYRED=new Color(193,23,23);
    CharExercise chE;
    ExerciseJlabel exerJLabel;
     String[] exercChars;
    private CharactersViewThread cvt;

    //Inner Class Exercise JLabel:
    class ExerciseJlabel extends JLabel {

        private Font exrcFont;

        private final String FONTNAME = "Courier New";
        private final int CHARSIZE = 300;

        ExerciseJlabel() {

            super();
            exrcFont = new Font(FONTNAME,Font.BOLD,CHARSIZE);

            this.setText("");
            setBounds(230, 80, CHARSIZE, CHARSIZE * 2);
            setFont(exrcFont);
            setForeground(Color.black);

        }

    }

    //inner class timetextfield for Time Question
    private class TimeTextField extends JTextField {

        private TimeTextField() {
            super("1000");
            setBounds(550, 60, 50, 20);
        }

    }

    public CharExercise() {

        super("Exercise Test");

        setLayout(null);
        setSize(700, 600);
        setDefaultCloseOperation(3);//exit on close
        setResizable(false);
        setFocusable(true);

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(getFocusOwner());
                if (canExercise) {
                    System.out.println("key press");
                    Character charAt = exerJLabel.getText().charAt(0);

                  
                    if (e.getKeyChar() == charAt) {
                        if (exerJLabel.getForeground() != MYGREEN) {
                            exerJLabel.setForeground(MYGREEN);
                            goodAnswer++;
                        }

                    }else{
                        if(exerJLabel.getForeground()!=MYGREEN){
                            exerJLabel.setForeground(MYRED);
                        }
                    }
                }
            }
        });

        container = getContentPane();
        container.setBackground(new Color(89, 100, 255));

        EnterCharTextField = new javax.swing.JTextField();
        GoButton = new javax.swing.JButton();
        exerJLabel = new ExerciseJlabel();
        timeTf = new TimeTextField();

        EnterCharTextField.setText("Enter You Want to Exrcise Characters");
        container.add(EnterCharTextField);
        EnterCharTextField.setBounds(22, 60, 210, 20);
        EnterCharTextField.addFocusListener((new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if (fe.getSource().equals(EnterCharTextField) && !focus) {
                    EnterCharTextField.setText("");
                    focus = true;
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {

            }
        }));
        GoButton.setText("Go!!!");
        container.add(GoButton);
        GoButton.setBounds(250, 60, 77, 23);

        GoButton.addActionListener(l -> {

            String charsRequest = EnterCharTextField.getText();
            String timeRequest = timeTf.getText();

            try {
                CheckRequest.checkCharacters(charsRequest);
                int checkTimeRequest = CheckRequest.checkTimeRequest(timeRequest);
                exercChars = DoExcercizeString.makeCharArray(DoExcercizeString.getDoExcerString(), charsRequest);
                Thread.sleep(2000);

                canExercise = true;

                revalidate();
                repaint();
                System.out.println(getFocusOwner());
                viewCharacterOtherThread( checkTimeRequest);

                EnterCharTextField.setEditable(false);
                GoButton.setEnabled(false);

                this.requestFocus();

            } catch (InsufficientQuantityCharacters | IllegalCharacter | NotExcersizeException ex) {
                EnterCharTextField.setText("");
                JOptionPane.showMessageDialog(rootPane, ex);
            } catch (NoTimeException | NO_OKTimeValue | NumberFormatException | SameCharsException ex) {
                timeTf.setText("1000");
                JOptionPane.showMessageDialog(rootPane, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(CharExercise.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        container.add(exerJLabel);
        WaitJLabel waitJL = new WaitJLabel();
        container.add(waitJL);
        container.add(timeTf);

    }

    //methods
    private void viewCharacterOtherThread( int checkTimeRequest) {

        cvt = new CharactersViewThread(this, checkTimeRequest);
        cvt.start();

    }

    public static void main(String[] args) {
        new CharExercise().setVisible(true);
    }

}
