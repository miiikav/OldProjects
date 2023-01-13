
package newpackage;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class NewMain extends JFrame {

    public NewMain() {

        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new NewMain();
                ex.setVisible(true);                
            }
        });
    }
}
