

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Oppilas
 */


public class Näkyvissä_V2 extends JApplet {
    
 JPanel paneeli;
 JLabel teksti;
 JButton nappi;
 int i=1;
    
    public void init() {
 paneeli =new JPanel();
 setContentPane(paneeli);
 teksti = new JLabel();
 teksti.setText("Näkyvissä!");
 paneeli.add(teksti);
 
 nappi=new JButton();
 paneeli.add(nappi);
nappi.setText("Näytä");
 nappi.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent e){


 if(i%2==0){ i++;
nappi.setText("Piilota");
 teksti.setVisible(true);

   }
 else { i++;
     nappi.setText("Näytä");
     teksti.setVisible(false);

 }

 }
 });

 }

}
         