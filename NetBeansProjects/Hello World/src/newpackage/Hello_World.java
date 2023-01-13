// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package newpackage;

import javax.swing.JApplet;
import java.awt.Graphics;
/**
 *
 * @author Oppilas
 */


public class Hello_World extends JApplet {

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
        g.drawString("Hello World", 10, 10);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
