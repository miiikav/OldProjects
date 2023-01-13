/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.pkg1;
import java.awt.*;
import java.applet.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tuomo
 */
public class Game extends Applet implements Runnable
{
   final int WIDTH = 1000;
   final int HEIGHT = 700;
   
   JFrame frame;
   Canvas canvas;
   BufferStrategy bufferStrategy;
   
	private CellSpace cellSpace;
	private Thread gameThread = null;
	private int genTime;
	private final String clear = "Clear";
	private final String glider = "Glider";
	private final String exploder1 = "Small Exploder";
	private final String exploder2 = "Exploder";
	private final String row10 = "10 Cell Row";
	private final String fish = "Fish";
	private final String pump = "Pump";
	private final String gun = "Shooter";
	private final String slow = "Slow";
	private final String fast = "Fast";
	private final String hyper = "Hyper";
	private final String nextLabel = "Next";
	private final String startLabel = "Start";
	private final String stopLabel = "Stop";
	private Label genLabel;
	private Button startstopButton;
          public Game(){
      frame = new JFrame("Basic Game");
      
      JPanel panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      panel.setLayout(null);
      
      canvas = new Canvas();
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
      
      panel.add(canvas);
      
      canvas.addMouseListener(new MouseControl());
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
      
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      
      canvas.requestFocus();
   }

    /**
     * Creates new form Game
     */
   public void init()
	{
		int cellSize;
		int cellCols;
		int cellRows;
		String param;

		// set background
		setBackground( new Color( 0x999999 ) );

		// read parameters from HTML
		param = getParameter("cellsize");
		if ( param == null) {
			cellSize = 11;
		} else
			cellSize = Integer.valueOf( param ).intValue();

		param = getParameter("cellcols");
		if ( param == null ) {
			cellCols = 40;
		} else
			cellCols = Integer.valueOf( param ).intValue();

		param = getParameter("cellrows");
		if ( param == null ) {
			cellRows = 25;
		} else
			cellRows = Integer.valueOf( param ).intValue();

		param = getParameter("gentime");
		if ( param == null ) {
			genTime = 500;
		} else
			genTime = Integer.valueOf( param ).intValue();

		// create components and add them to container
		cellSpace = new CellSpace( cellSize, cellCols, cellRows );

		Choice c = new Choice();
		c.addItem( clear );
		c.addItem( glider );
		c.addItem( exploder2 );
		c.addItem( exploder1 );
		c.addItem( row10 );
		c.addItem( fish );
		c.addItem( pump );
		c.addItem( gun );
                
                Choice speed = new Choice();
                speed.addItem( slow );
                speed.addItem( fast );
                speed.addItem( hyper );

		genLabel = new Label( "Generations: 0             " );

		startstopButton = new Button( startLabel );

		Panel controls = new Panel();
		controls.add( c );
		controls.add( new Button( nextLabel ));
		controls.add( startstopButton );
		controls.add( speed );
		controls.add( genLabel );

		setLayout(new BorderLayout());
		add( "South", controls );
		add( "North", cellSpace );
                show();
		resize( preferredSize() );
                validate();
	}

	// no start() to prevent starting immediately
	public void start2() {
		if(gameThread == null) {
			gameThread = new Thread(this);
			gameThread.start();
		}
	}

	public void stop() {
		if(gameThread != null) {
			gameThread.stop();
			gameThread = null;
		}
	}

	public void run() {
		while (gameThread != null) {
			cellSpace.next();
			cellSpace.repaint();
			showGenerations();
			try {
				gameThread.sleep( genTime );
			} catch (InterruptedException e){}
		}
	}

	public boolean action(Event evt, Object arg) {
		if( clear.equals( arg ) ) // clear
                {
                        cellSpace.clear();
                        cellSpace.repaint();
                        showGenerations();
                        return true;
                }
                else if( glider.equals( arg ) ) // misc shapes
                {
                        int shape[] = { 0,1, 1,2, 2,2, 2,1, 2,0 };
                        drawShape( 3, 3, shape );
                        return true;
                }
                else if( exploder1.equals( arg ) )
                {
                        int shape[] = { 0,1, 0,2, 1,0, 1,1, 1,3, 2,1, 2,2 };
                        drawShape( 3, 4, shape );
                        return true;
                }
                else if(exploder2.equals(arg))
                {
                        int shape[] = { 0,0, 0,1, 0,2, 0,3, 0,4, 2,0, 2,4, 4,0, 4,1, 4,2, 4,3, 4,4 };
                        drawShape( 5, 5, shape );
                        return true;
                }
                else if(row10.equals(arg))
                {
                        int shape[] = { 0,0, 1,0, 2,0, 3,0, 4,0, 5,0, 6,0, 7,0, 8,0, 9,0 };
                        drawShape( 10, 1, shape );
                        return true;
                }
                else if(fish.equals(arg))
                {
                        int shape[] = { 0,1, 0,3, 1,0, 2,0, 3,0, 3,3, 4,0, 4,1, 4,2 };
                        drawShape( 5, 4, shape );
                        return true;
                }
                else if(pump.equals(arg))
                {
                        int shape[] = { 0,3, 0,4, 0,5, 1,0, 1,1, 1,5, 2,0, 2,1, 2,2, 2,3, 2,4, 4,0, 4,1, 4,2, 4,3, 4,4, 5,0, 5,1, 5,5, 6,3, 6,4, 6,5 };
                        drawShape( 7, 6, shape );
                        return true;
                }
                else if(gun.equals(arg))
                {
                        int shape[] = { 0,2, 0,3, 1,2, 1,3, 8,3, 8,4, 9,2, 9,4, 10,2, 10,3, 16,4, 16,5, 16,6, 17,4, 18,5, 22,1, 22,2, 23,0, 23,2, 24,0, 24,1, 24,12, 24,13, 25,12, 25,14, 26,12, 34,0, 34,1, 35,0, 35,1, 35,7, 35,8, 35,9, 36,7, 37,8 };
                        drawShape( 38, 15, shape );
                        return true;
                }
                else if(nextLabel.equals(arg)) // next
                {
                        cellSpace.next();
                        cellSpace.repaint();
                        showGenerations();
                        return true;
                }
                else if(startLabel.equals(arg)) // start
                {
                        start2();
                        startstopButton.setLabel( stopLabel );
                        return true;
                }
                else if(stopLabel.equals(arg)) // stop
                {
                        stop();
                        startstopButton.setLabel( startLabel );
                        return true;
                }
                else if(slow.equals(arg)) // slow
                {
                        genTime = 500;
                        return true;
                }
                else if(fast.equals(arg)) // fast
                {
                        genTime = 100;
                        return true;
                }
                else if(hyper.equals(arg)) // hyperspeed
                {
                        genTime = 0;
                        return true;
                }
                return false;
            }

		public String getAppletInfo()
		{
			return "Game Of Life v. 1.3\nCopyright 1996-2001 Edwin Martin";
		}

		// show number of generations
		public void showGenerations() {
			genLabel.setText( "Generations: "+cellSpace.generations );
		}

		// draws the shape to canvas
		public void drawShape( int shapeWidth, int shapeHeight, int shape[] ) {
			if ( !cellSpace.drawShape( shapeWidth, shapeHeight, shape ) )
				showStatus( "Shape is too big to fit." );
			else {
				showStatus( "" );
				cellSpace.repaint();
				showGenerations();
			}
		}

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
