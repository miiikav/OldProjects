
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Oppilas
 */


public class Näkyvissä extends JApplet {
    
 JPanel paneeli;
 JLabel teksti;
 JButton näkyvissä;
 JButton piilossa;
 
    
    public void init() {
 paneeli =new JPanel();
 setContentPane(paneeli);
 teksti = new JLabel();
 teksti.setText("Näkyvissä!");
 paneeli.add(teksti);
 
 näkyvissä=new JButton();
 näkyvissä.setText("Näytä");
 paneeli.add(näkyvissä);
 näkyvissä.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent e){
 teksti.setVisible(false);
 }
  });
  
 piilossa=new JButton();
 piilossa.setText("Piilota");
 paneeli.add(piilossa);
 piilossa.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent e){
 teksti.setVisible(true);
 
 

 }
});
    }
}
         