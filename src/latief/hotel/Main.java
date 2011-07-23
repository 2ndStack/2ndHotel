/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package latief.hotel;

import javax.swing.UIManager;
import latief.hotel.swing.JMainFrame;

/**
 *
 * @author Latief
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }


        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JMainFrame().setVisible(true);
            }
        });
    }
}
