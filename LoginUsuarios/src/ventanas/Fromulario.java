package ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

class Formulario extends JPanel {
    public Formulario(){
        imagen = new ImageIcon("images/pikawaii.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(label_imagen.getWidth(),
                label_imagen.getHeight(),
                Image.SCALE_DEFAULT));

        label_imagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(125,125,Image.SCALE_SMOOTH)));
        add(label_imagen);
        setVisible(true);
    }/*
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //dibujar una imagen en la lámina
        /*try{
            //la clase ImageIO lanza una excepción si no la encuentra
            //al método read le pasamos un objeto File para que traiga
            imagen = ImageIO.read(new File("images/pikawaii.png"));
        }
        catch(Exception e){
            System.out.println("ERROR: imagen no encontrada");//si no lo encuentra, pasa esto
        }
        //dibujamos la imagen dentro de la lámina
        imagen = new ImageIcon("images/pikawaii.png");
        label_imagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(125,125,Image.SCALE_SMOOTH)));
        g.drawImage(imagen, 15, 30, null);
    }*/
    JLabel label_imagen;
    ImageIcon imagen;
}