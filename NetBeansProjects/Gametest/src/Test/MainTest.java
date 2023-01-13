package Test;


import java.awt.EventQueue;
import javax.swing.JFrame;


public class MainTest extends JFrame {

    public MainTest() {

        add(new test());
        
        setResizable(false);
        pack();
        
        setTitle("Test");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new MainTest();
                ex.setVisible(true);                
            }
        });
    }
}
