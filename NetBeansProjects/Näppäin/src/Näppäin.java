
import javax.swing.*;

/**
 *
 * @author Oppilas
 */


public class Näppäin extends JApplet {

    JPanel paneeli;
    JLabel teksti;
    JButton näppäin;

    public void init() {
        
        paneeli = new JPanel();
        setContentPane(paneeli);
        
        JLabel teksti = new JLabel();
        teksti.setText("Hello World");
        paneeli.add(teksti);
        näppäin = new JButton();
        näppäin.setText("paina tästä!");
        paneeli.add(näppäin);
        
        
    }
    
    
    
}
