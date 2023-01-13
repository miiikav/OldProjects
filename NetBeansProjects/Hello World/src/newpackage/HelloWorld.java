// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package newpackage;

import javax.swing.*;

/**
 *
 * @author Oppilas
 */


public class HelloWorld extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        JPanel paneeli;
        paneeli = new JPanel();
        setContentPane(paneeli);
        
        JLabel näppäin = new JLabel();
        näppäin.addKeyListener(null);
        paneeli.add(näppäin);
        
        JLabel teksti = new JLabel();
        teksti.setText("Hello World");
        paneeli.add(teksti);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
