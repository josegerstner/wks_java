

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class AppletMultimedia extends JApplet{
	public void init(){
		logo = getImage(getDocumentBase(), "pikawaii.gif");
		setSize(350,250);
	}
	public void paint(Graphics g){
		g.drawImage(logo, 0, 0, this);
		
	}
	Image logo;
}
