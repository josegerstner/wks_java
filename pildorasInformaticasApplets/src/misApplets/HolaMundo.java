package misApplets;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HolaMundo extends JApplet{
	public void init(){
		//setBounds(400, 200, 400, 400);
		JLabel rotulo = new JLabel("Hola mundo", SwingConstants.CENTER);
		add(rotulo);
	}
}
