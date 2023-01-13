package Tikku;


//Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author Oppilas
 */


public class Ukko extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        //Tikku ukko
        g.drawLine(65, 140, 65, 65);
        g.fillOval(40, 30, 50, 50);
        g.drawLine(30,115, 65, 90);
        g.drawLine(80,130, 65, 90);
        g.drawLine(40,190, 65, 140);
        g.drawLine(65, 140, 110, 190);
        //Tausta
        g.drawLine(5,5,400,70);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
