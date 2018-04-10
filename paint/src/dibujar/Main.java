package dibujar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame{
	private Dibujo canvas1;
	public Main(){
		initComponents();
		canvas1 = new Dibujo();
		canvas1.setBounds(20, 40, 600, 400);
		canvas1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				canvas1.mousePressed(e);
			}
		});
		canvas1.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				canvas1.mouseDragged(e);
			}
		});
		this.add(canvas1);
	}                          
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 700, Short.MAX_VALUE));
		layout.setVerticalGroup(
		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 500, Short.MAX_VALUE));
        pack();
        setTitle("Paint en Java =o");
    }                        
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}

